package com.green.sahwang.service.impl;

import com.green.sahwang.config.AvroToDBSerializer;
import com.green.sahwang.entity.OutboxMessage;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.exception.outbox.OutboxSerializeEventException;
import com.green.sahwang.exception.payment.PaymentFailureException;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.model.payment.avro.PaymentMethod;
import com.green.sahwang.model.payment.avro.PaymentStatus;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.model.purchase.avro.ProductAvroModel;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.repository.OutboxRepository;
import com.green.sahwang.repository.PurchaseProductRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private static final String PURCHASE_PREFIX = "purchase:";
    private static final String MEMBER_PREFIX = "member:";

    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final OutboxRepository outboxRepository;

    @Override
    @Transactional
    public void processPayment(List<String> purchaseIds, List<PurchaseCreatedEventAvroModel> messages) {

        for (String purchaseId : purchaseIds) {
            String PREFIX = purchaseId.split(":")[0];
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            Purchase purchase = purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));

            // Idempotency
            purchase.doReadyForPay();
            purchaseRepository.save(purchase);

            List<PurchaseProduct> orderedProducts = new ArrayList<>();
            // PaymentServiceHelper ...
            List<PurchaseCreatedEventAvroModel> collect = messages.stream().collect(Collectors.toList());
            for (PurchaseCreatedEventAvroModel purchaseCreatedEventAvroModel : collect) {

                List<ProductAvroModel> products = purchaseCreatedEventAvroModel.getProducts();
                for (ProductAvroModel productAvroModel : products) {
                    String productId = productAvroModel.getProductId();
                    PurchaseProduct purchaseProduct = purchaseProductRepository.findByProductIdAndPurchaseId(Long.valueOf(productId),
                                    Long.valueOf(purchaseKeyId))
                            .orElseThrow(() -> new PurchaseDomainException("주문 상품 내역이 존재하지 않습니다."));

                    log.info("주문상품 : {}, 상품 ID : {}", purchaseProduct.toString(), purchaseProduct.getProduct().getId());
                    orderedProducts.add(purchaseProduct);
                }
            }

            log.info("purchaseId, PREFIX : {}, VALUE : {}", PREFIX, purchaseKeyId);

            // external payment API processes...
            CompletableFuture.supplyAsync(() -> processPayExternalAPI(purchaseKeyId, orderedProducts))
                    .thenApply(isPaid -> {
                        if (isPaid) {
                            purchase.pay();
                            return purchase;
                        } else {
                            throw new PaymentFailureException("결제 실패");
                        }
                    }).thenAccept(resPurchase -> {
                        // 결제 성공 후에만 배송 시작 이벤트를 Outbox에 기록
                        createPaymentOutboxMessage(purchaseId, resPurchase);
                    }).exceptionally(ex -> {
                        // 보상 트랜잭션 설계와 카프카 실패 이벤트 발행
                        return null;
                    });

            log.info("외부 결제 API 요청 전송");
        }
    }

    private void createPaymentOutboxMessage(String purchaseId, Purchase purchase) {
        PurchasePaidEventAvroModel purchasePaidEventAvroModel = PurchasePaidEventAvroModel.newBuilder()
                .setPurchaseId(purchaseId)
                .setMemberId(MEMBER_PREFIX + purchase.getMember().getId())
                .setPaymentStatus(PaymentStatus.PAYING)
                .setPaymentMethod(PaymentMethod.CREDIT_CARD)
                .setTransactionId("TEMP")
                .setTimestamp(System.currentTimeMillis())
                .setAmount(0)
                .build();

        OutboxMessage outboxMessage;
        try {
            outboxMessage = OutboxMessage.builder()
                    .aggregateId(purchaseId)
                    .avroModel(purchasePaidEventAvroModel.getClass().getName())
                    .eventType("Payment")
                    .topicName("payment-paid")
                    .payload(AvroToDBSerializer.serialize(purchasePaidEventAvroModel))
                    .sequenceNumber(System.currentTimeMillis())
                    .status("PENDING")
                    .createdAt(LocalDateTime.now())
                    .build();
        } catch (Exception e) {
            throw new OutboxSerializeEventException("Failed to serialize outboxMessage: " + e.getMessage());
        }

        outboxRepository.save(outboxMessage);
        log.info("outboxMessage = {}", outboxMessage);
    }

    // todo
    private boolean processPayExternalAPI(String purchaseKeyId, List<PurchaseProduct> orderedProducts) {
        log.info("외부 결제 API 처리 중");
        return true;
    }
}
