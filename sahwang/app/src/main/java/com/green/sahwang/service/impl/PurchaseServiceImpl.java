package com.green.sahwang.service.impl;

import com.green.sahwang.config.AvroToDBSerializer;
import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.model.purchase.avro.ProductAvroModel;
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
    public void createPurchase(String memberId) {

        // dto -> entity
        // 1. ModelMapper
        // 2. builder
        // 3. getter setter
        // entity <-> repository
        Member member = memberRepository.findById(Long.valueOf(memberId))
                .orElseThrow(() -> new PurchaseDomainException("사용자를 찾을 수 없습니다."));

        // 나중에 소스 수정할 곳
        Candle candle1 = new Candle();
        Candle candle2 = new Candle();
        candle1.setName("초1");
        candle2.setName("초2");
        productRepository.save(candle1);
        productRepository.save(candle2);


        Purchase purchase = Purchase.builder()
                .member(member)
                .purchaseStatus(PurchaseStatus.CREATED)
                .build();
        Purchase savedPurchase = purchaseRepository.save(purchase);

        // 프론트에서 보낸 상품 리스트가 들어올거라 생각하고 짜자
        // List<Product> products
        List<Product> products = new ArrayList<>();
        products.add(candle1);
        products.add(candle2);

        for (Product product : products) {
            Product findProduct = productRepository.findById(product.getId())
                    .orElseThrow(() -> new ProductDomainException("해당 " + product.getId() + "제품이 없습니다"));

            PurchaseProduct purchaseProduct = PurchaseProduct.builder()
                    .purchase(savedPurchase)
                    .product(findProduct)
                    .build();

            purchaseProductRepository.save(purchaseProduct);
        }

        List<ProductAvroModel> productAvroModels = products.stream()
                .map(product -> ProductAvroModel.newBuilder()
                        .setProductId(String.valueOf(product.getId()))
                        .build())
                .toList();


        PurchaseCreatedEventAvroModel purchaseCreatedEventAvroModel = PurchaseCreatedEventAvroModel.newBuilder()
                .setPurchaseId(PREFIX + savedPurchase.getId())
                .setMemberId("memberId:" + savedPurchase.getMember().getId())
                .setProducts(new ArrayList<>(productAvroModels))
                .setTimestamp(System.currentTimeMillis())
                .build();

        OutboxMessage outboxMessage = createPurchaseOutboxMessage(savedPurchase.getId(), purchaseCreatedEventAvroModel);
        log.info("outboxMessage = {}", outboxMessage.toString());
    }

    // payload 직렬화는 추후에
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
                    .status("PENDING")
                    .createdAt(LocalDateTime.now())
                    .build();
        } catch (Exception e) {
            throw new PurchaseDomainException("failed serializer");
        }

        outboxRepository.save(outboxMessage);
        return outboxMessage;
    }
}
