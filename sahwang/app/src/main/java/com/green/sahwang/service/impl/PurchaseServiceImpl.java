package com.green.sahwang.service.impl;

import com.green.sahwang.config.AvroToDBSerializer;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.purchase.dto.request.PurchaseReqDto;
import com.green.sahwang.purchase.dto.response.PurchaseResDto;
import com.green.sahwang.dto.response.externalapi.ExternalPaymentResDto;
import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.OutboxStatus;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.model.purchase.avro.PurchaseAvroModel;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.repository.*;
import com.green.sahwang.service.PurchaseService;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private static final String PREFIX = "purchase:";

    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final MemberRepository memberRepository;
    private final UsedProductRepository usedProductRepository;
    private final OutboxRepository outboxRepository;

    @Override
    @Transactional
    public PurchaseResDto createPurchase(PurchaseReqDto purchaseReqDto, String userEmail) {
        Member member = memberRepository.findByEmail(userEmail);

        List<UsedProduct> usedProducts = usedProductRepository.findAllById(purchaseReqDto.getPurchaseProductDtos().stream()
                .map(purchaseProductReqDto -> purchaseProductReqDto.getUsedProductId())
                .toList());

        Purchase purchase = Purchase.builder()
                .member(member)
                .purchaseStatus(PurchaseStatus.CREATED)
                .purchaseDate(LocalDateTime.now())
                .totalPrice(usedProducts.stream()
                        .mapToInt(usedProduct -> usedProduct.getVerifiedSale().getPendingSale().getExceptedSellingPrice() * getCartProductQuantity(purchaseReqDto, usedProduct))
                        .sum())
                .build();

        log.info("purchase 사전 총합 : {}", purchase.getTotalPrice());
        log.info("purchaseReqDto.getTotalPrice() 사전 총합 : {}", purchaseReqDto.getTotalPrice());

        if (purchase.getTotalPrice() != purchaseReqDto.getTotalPrice()) {
            throw new BizException(ErrorCode.NO_ACCEPT_PRE_VERIFICATION);
        }

        Purchase savedPurchase = purchaseRepository.save(purchase);

        for (UsedProduct usedProduct : usedProducts) {
            UsedProduct findUsedProduct = usedProductRepository.findById(usedProduct.getId())
                    .orElseThrow(() -> new BizException(ErrorCode.NO_USED_PRODUCT));

            Integer cartProductQuantity = getCartProductQuantity(purchaseReqDto, findUsedProduct);

            PurchaseProduct purchaseProduct = PurchaseProduct.builder()
                    .purchase(savedPurchase)
                    .productName(usedProduct.getVerifiedSale().getProductName())
                    .usedProduct(usedProduct)
                    .productQuantity(cartProductQuantity)
                    .purchaseCreationDate(LocalDateTime.now())
                    .build();

            purchaseProductRepository.save(purchaseProduct);
        }

        PurchaseCreatedEventAvroModel purchaseCreatedEventAvroModel =
                getPurchaseCreatedEventAvroModel(purchaseReqDto, savedPurchase);

        OutboxMessage outboxMessage = createPurchaseOutboxMessage(savedPurchase.getId(), purchaseCreatedEventAvroModel);
        log.info("outboxMessage = {}", outboxMessage.toString());

        return PurchaseResDto.builder()
                .purchaseId(purchase.getId())
                .memberId(purchase.getMember().getId())
                .build();
    }

    @Override
    public ExternalPaymentResDto purchaseCompleted(String merchantUid) {
        return null;
    }

    private Integer getCartProductQuantity(PurchaseReqDto purchaseReqDto, UsedProduct usedProduct) {
        return purchaseReqDto.getPurchaseProductDtos().stream()
                .filter(purchaseProductReqDto -> purchaseProductReqDto.getUsedProductId().equals(usedProduct.getId()))
                .map(purchaseProductReqDto -> purchaseProductReqDto.getQuantity())
                .findFirst()
                .orElseThrow(() -> new PurchaseDomainException("해당 " + usedProduct.getId() + " 제품의 수량이 없습니다."));
    }

    private PurchaseCreatedEventAvroModel getPurchaseCreatedEventAvroModel(PurchaseReqDto purchaseReqDto, Purchase savedPurchase) {
        List<PurchaseAvroModel> productAvroModels = purchaseReqDto.getPurchaseProductDtos().stream()
                .map(purchaseProductReqDto -> PurchaseAvroModel.newBuilder()
                        .setUsedProductId(String.valueOf(purchaseProductReqDto.getUsedProductId()))
                        .setQuantity(purchaseProductReqDto.getQuantity())
                        .build())
                .toList();


        return PurchaseCreatedEventAvroModel.newBuilder()
                .setPurchaseId(PREFIX + savedPurchase.getId())
                .setMemberId("memberId:" + savedPurchase.getMember().getId())
                .setUsedProducts(new ArrayList<>(productAvroModels))
                .setTimestamp(System.currentTimeMillis())
                .setTotalPrice(purchaseReqDto.getTotalPrice())
                .build();
    }

    private OutboxMessage createPurchaseOutboxMessage(Long purchaseId, PurchaseCreatedEventAvroModel purchaseCreatedEventAvroModel) {
        OutboxMessage outboxMessage;
        try {
            outboxMessage = OutboxMessage.builder()
                    .aggregateId(PREFIX + purchaseId)
                    .avroModel(purchaseCreatedEventAvroModel.getClass().getName())
                    .eventType("Purchase")
                    .topicName("purchase-created")
                    .payload(AvroToDBSerializer.serialize(purchaseCreatedEventAvroModel))
                    .sequenceNumber(System.currentTimeMillis())
                    .status(OutboxStatus.CREATED)
                    .createdAt(LocalDateTime.now())
                    .build();
        } catch (Exception e) {
            throw new PurchaseDomainException("failed serializer");
        }

        outboxRepository.save(outboxMessage);
        return outboxMessage;
    }

}
