package com.green.sahwang.service.impl;

import com.green.sahwang.config.AvroToDBSerializer;
import com.green.sahwang.dto.request.PaymentCompleteRequest;
import com.green.sahwang.entity.OutboxMessage;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.entity.enumtype.OutboxStatus;
import com.green.sahwang.exception.outbox.OutboxSerializeEventException;
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
import com.siot.IamportRestClient.IamportClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private IamportClient paymentExternalApi;

    @Value("${imp.api.key}")
    private String apiKey;

    @Value("${imp.api.apiSecret}")
    private String apiSecret;

    @PostConstruct
    public void init() {
        this.paymentExternalApi = new IamportClient(apiKey, apiSecret);
    }

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
        }
    }

    @Override
    @Transactional
    public void processAsyncPayment(PaymentCompleteRequest paymentCompleteRequest) {
        // 사용자가 결제 완료 후 사후 검증 메서드 구현 ...
        String purchaseId = paymentCompleteRequest.getPurchaseId();
        String aggregateId = modifyOutboxStatusToSendPaidEvent(purchaseId);
        Optional<Purchase> purchase = purchaseRepository.findById(Long.valueOf(purchaseId));
        createPaymentPaidOutboxMessage(aggregateId, purchase.get());
    }

    @Override
    public void validateOrder(List<String> purchaseIds, List<PurchaseCreatedEventAvroModel> messages) {
        // 결제 사전 검증 로직 메서드 구현 ... -> 생각중

        for (String purchaseId : purchaseIds) {
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            Purchase purchase = purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));

//            purchase.doReadyForPay();
//            purchaseRepository.save(purchase);
        }
    }

    private String modifyOutboxStatusToSendPaidEvent(String purchaseId) {
        String aggregateId = PURCHASE_PREFIX + purchaseId;
        OutboxMessage outboxMessage = outboxRepository.findByAggregateId(aggregateId)
                .orElseThrow(() -> new PurchaseDomainException("No outbox purchase event"));
        outboxMessage.setStatus(OutboxStatus.PENDING);
        outboxRepository.save(outboxMessage);
        return aggregateId;
    }

    private void createPaymentPaidOutboxMessage(String purchaseId, Purchase purchase) {
        purchase.pay();
        purchaseRepository.save(purchase);

        PurchasePaidEventAvroModel purchasePaidEventAvroModel = PurchasePaidEventAvroModel.newBuilder()
                .setPurchaseId(purchaseId)
                .setMemberId(MEMBER_PREFIX + purchase.getMember().getId())
                .setPaymentStatus(PaymentStatus.PAID)
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
                    .status(OutboxStatus.PENDING)
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
