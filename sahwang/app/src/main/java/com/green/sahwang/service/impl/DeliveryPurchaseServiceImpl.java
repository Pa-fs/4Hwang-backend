package com.green.sahwang.service.impl;

import com.green.sahwang.config.AvroToDBSerializer;
import com.green.sahwang.controller.NotificationService;
import com.green.sahwang.entity.DeliveryPurchase;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.OutboxMessage;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.enumtype.OutboxStatus;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.entity.enumtype.ShipStatus;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.exception.outbox.OutboxSerializeEventException;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.model.purchase.avro.PurchaseCompletedEventAvroModel;
import com.green.sahwang.repository.DeliveryPurchasesRepository;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.OutboxRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.service.DeliveryPurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryPurchaseServiceImpl implements DeliveryPurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final MemberRepository memberRepository;
    private final OutboxRepository outboxRepository;
    private final NotificationService notificationService;
    private final DeliveryPurchasesRepository deliveryPurchasesRepository;

    @Override
    @Transactional
    public void processDeliveryPurchase(List<String> memberIds, List<PurchasePaidEventAvroModel> messages) {

        for (String memberId : memberIds) {
            String memberKeyId = memberId.split(":")[1];
            log.info("memberKeyId = {}", memberKeyId);
            Member member = memberRepository.findById(Long.valueOf(memberKeyId))
                    .orElseThrow(() -> new BizException(ErrorCode.NO_MEMBER));

            List<PurchasePaidEventAvroModel> purchasePaidEventAvroModels = messages.stream().toList();
            for (PurchasePaidEventAvroModel purchasePaidEventAvroModel : purchasePaidEventAvroModels) {
                log.info("purchasePaidEventAvroModel.getPurchaseId() : {}", purchasePaidEventAvroModel.getPurchaseId());
                Purchase purchase = purchaseRepository.findById(Long.valueOf(purchasePaidEventAvroModel.getPurchaseId()))
                        .orElseThrow(() -> new BizException(ErrorCode.NO_PURCHASE));
                if (purchase != null && purchase.getPurchaseStatus() != PurchaseStatus.PAID) {
                    String shippingAddress = purchasePaidEventAvroModel.getShippingAddress();

                    log.info("목적지 주소 : {}", shippingAddress);

//                    createPurchaseCompletedOutboxMessage(purchase);

                    // 배송 프로세스 시작
                    log.info("주문완료 이벤트 발행, 구매번호 : {}", purchase.getId());

                    if(purchase.getPurchaseStatus().equals(PurchaseStatus.SHIP_READY))
                        shippingProcess();
                    if(purchase.getPurchaseStatus().equals(PurchaseStatus.SHIPPING))
                        shippedProcess();
                    break;
                }
            }

        }
    }


//    @Scheduled(fixedRate = 600000)
    public void shippingProcess() {
        List<Purchase> purchases = purchaseRepository.findByPurchaseStatus(PurchaseStatus.SHIP_READY);

        purchases.forEach(purchase -> {
                    if (purchase != null) {
                        DeliveryPurchase deliveryPurchase = DeliveryPurchase.builder()
                                .purchase(purchase)
                                .status(ShipStatus.SHIPPING)
                                .deliveredDate(LocalDateTime.now())
                                .build();
                        deliveryPurchasesRepository.save(deliveryPurchase);
                        purchase.setPurchaseStatus(PurchaseStatus.SHIPPING);
                        purchaseRepository.save(purchase);
                    }
                });
    }
//    @Scheduled(fixedRate = 600000)
    public void shippedProcess() {
        List<Purchase> purchases = purchaseRepository.findByPurchaseStatus(PurchaseStatus.SHIPPING);

        purchases.forEach(purchase -> {
            if (purchase != null) {
                DeliveryPurchase deliveryPurchase = DeliveryPurchase.builder()
                        .purchase(purchase)
                        .status(ShipStatus.SHIPPED)
                        .deliveredDate(LocalDateTime.now())
                        .build();
                deliveryPurchasesRepository.save(deliveryPurchase);
                purchase.setPurchaseStatus(PurchaseStatus.SHIPPED);
                purchaseRepository.save(purchase);
            }
        });
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
