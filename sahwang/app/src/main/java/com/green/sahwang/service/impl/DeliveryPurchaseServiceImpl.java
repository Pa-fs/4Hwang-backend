package com.green.sahwang.service.impl;

import com.green.sahwang.config.AvroToDBSerializer;
import com.green.sahwang.entity.OutboxMessage;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.enumtype.OutboxStatus;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.exception.outbox.OutboxSerializeEventException;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel;
import com.green.sahwang.repository.OutboxRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.service.DeliveryPurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryPurchaseServiceImpl implements DeliveryPurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final OutboxRepository outboxRepository;

    @Override
    @Transactional
    public void processDeliveryPurchase(List<String> purchaseIds, List<PurchasePaidEventAvroModel> messages) {

        for (String purchaseId : purchaseIds) {
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            Purchase purchase = purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));

            // Idempotency
            purchase.validatePaidCompletedStatus();

            log.info("purchaseId : {}", purchaseId);
            log.info("해당 구매번호 : {}, 배송 준비 중", purchaseKeyId);

            String shippingAddress = null;
            List<PurchasePaidEventAvroModel> purchasePaidEventAvroModels = messages.stream().toList();
            for (PurchasePaidEventAvroModel purchasePaidEventAvroModel : purchasePaidEventAvroModels) {
                log.info("purchasePaidEventAvroModel.getPurchaseId() : ", purchasePaidEventAvroModel.getPurchaseId());
                if(purchaseId.equals("purchase:" + purchasePaidEventAvroModel.getPurchaseId())) {
                    shippingAddress = purchasePaidEventAvroModel.getShippingAddress();
                    break;
                }
            }

            log.info("목적지 주소 : {}", shippingAddress);

//            createPurchaseCompletedOutboxMessage(purchase);

            // 알림서비스 추가 될 곳 (주문완료)

            // 배송 프로세스 시작

//            log.info("주문완료 이벤트 발행, 구매번호 : {}", purchaseKeyId);
        }
    }

    private void createPurchaseCompletedOutboxMessage(Purchase purchase) {
        PurchaseCompletedEventAvroModel purchaseCompletedEventAvroModel = PurchaseCompletedEventAvroModel.newBuilder()
                .setPurchaseId(purchase.getId().toString())
                .setMemberId(purchase.getMember().getId().toString())
                .setPurchaseStatus(String.valueOf(PurchaseStatus.SHIP_READY))
                .setTotalAmount(0)
                .setShippingAddress("TEMP")
                .setPurchaseDate(System.currentTimeMillis())
                .build();


        OutboxMessage outboxMessage = null;
        try {
            outboxMessage = OutboxMessage.builder()
                    .aggregateId("purchase:" + purchase.getId())
                    .avroModel(purchaseCompletedEventAvroModel.getClass().getName())
                    .eventType("Purchase")
                    .topicName("purchase-completed")
                    .payload(AvroToDBSerializer.serialize(purchaseCompletedEventAvroModel))
                    .sequenceNumber(System.currentTimeMillis())
                    .status(OutboxStatus.PENDING)
                    .createdAt(LocalDateTime.now())
                    .build();
        } catch (Exception e) {
            throw new OutboxSerializeEventException("주문완료 이벤트가 직렬화에 실패했습니다");
        }

        outboxRepository.save(outboxMessage);
    }
}
