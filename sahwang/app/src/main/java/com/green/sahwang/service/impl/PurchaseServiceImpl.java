package com.green.sahwang.service.impl;

import com.green.sahwang.config.AvroToDBSerializer;
import com.green.sahwang.dto.request.PurchaseReqDto;
import com.green.sahwang.dto.response.PurchaseResDto;
import com.green.sahwang.dto.response.externalapi.ExternalPaymentResDto;
import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.OutboxStatus;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.model.purchase.avro.PurchaseAvroModel;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.repository.*;
import com.green.sahwang.service.PurchaseService;
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
    private final ProductRepository productRepository;
    private final OutboxRepository outboxRepository;

    @Override
    @Transactional
    public PurchaseResDto createPurchase(PurchaseReqDto purchaseReqDto, String userEmail) {

        // dto -> entity
        // 1. ModelMapper
        // 2. builder
        // 3. getter setter
        // entity <-> repository
//        Member member = memberRepository.findByEmail(userEmail);

        // 테스트 데이터
        Member member = memberRepository.findById(1L)
                .orElse(null);

        List<Product> products = productRepository.findAllById(purchaseReqDto.getPurchaseProductDtos().stream()
                .map(purchaseProductReqDto -> purchaseProductReqDto.getProductId())
                .toList());

        Purchase purchase = Purchase.builder()
                .member(member)
                .purchaseStatus(PurchaseStatus.CREATED)
                .purchaseDate(LocalDateTime.now())
                .totalPrice(products.stream()
                        .mapToInt(product -> product.getPrice() * getCartProductQuantity(purchaseReqDto, product))
                        .sum())
                .build();

        log.info("purchase 사전 총합 : {}", purchase.getTotalPrice());
        log.info("purchaseReqDto.getTotalPrice() 사전 총합 : {}", purchaseReqDto.getTotalPrice());

        if (purchase.getTotalPrice() != purchaseReqDto.getTotalPrice()) {
            throw new PurchaseDomainException("사전 총 결제 금액이 맞지 않습니다.");
        }

        Purchase savedPurchase = purchaseRepository.save(purchase);

        for (Product product : products) {
            Product findProduct = productRepository.findById(product.getId())
                    .orElseThrow(() -> new ProductDomainException("해당 " + product.getId() + "제품이 없습니다"));

            Integer cartProductQuantity = getCartProductQuantity(purchaseReqDto, product);

            PurchaseProduct purchaseProduct = PurchaseProduct.builder()
                    .purchase(savedPurchase)
                    .productName(findProduct.getName())
                    .product(findProduct)
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

    private Integer getCartProductQuantity(PurchaseReqDto purchaseReqDto, Product product) {
        return purchaseReqDto.getPurchaseProductDtos().stream()
                .filter(purchaseProductReqDto -> purchaseProductReqDto.getProductId().equals(product.getId()))
                .map(purchaseProductReqDto -> purchaseProductReqDto.getQuantity())
                .findFirst()
                .orElseThrow(() -> new PurchaseDomainException("해당 " + product.getId() + " 제품의 수량이 없습니다."));
    }

    private PurchaseCreatedEventAvroModel getPurchaseCreatedEventAvroModel(PurchaseReqDto purchaseReqDto, Purchase savedPurchase) {
        List<PurchaseAvroModel> productAvroModels = purchaseReqDto.getPurchaseProductDtos().stream()
                .map(purchaseProductReqDto -> PurchaseAvroModel.newBuilder()
                        .setProductId(String.valueOf(purchaseProductReqDto.getProductId()))
                        .setQuantity(purchaseProductReqDto.getQuantity())
                        .build())
                .toList();


        return PurchaseCreatedEventAvroModel.newBuilder()
                .setPurchaseId(PREFIX + savedPurchase.getId())
                .setMemberId("memberId:" + savedPurchase.getMember().getId())
                .setProducts(new ArrayList<>(productAvroModels))
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
