package com.green.sahwang.controller;

import com.green.sahwang.entity.Payment;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.exception.payment.PaymentDomainException;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.repository.OutboxRepository;
import com.green.sahwang.repository.PaymentRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.service.SseEmitterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final PurchaseRepository purchaseRepository;
    private final SseEmitterService sseEmitterService;
    private final PaymentRepository paymentRepository;

    public void paymentCompletedUniCast(List<String> purchaseIds, List<PurchasePaidEventAvroModel> messages) {
        for (String purchaseId : purchaseIds) {
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            Purchase purchase = purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));

            // Idempotency
            purchase.doReadyForShip();

//            List<SseEmitter> deadEmitters = new ArrayList<>();
//            for (SseEmitter emitter : SSE_EMITTERS) {
//                try {
//                    emitter.send(SseEmitter.event().name("paidCompleted")
//                            .data(purchase.getPurchaseStatus()));
//                } catch (IOException e) {
//                    deadEmitters.add(emitter);
//                }
//            }
//            SSE_EMITTERS.removeAll(deadEmitters);

            int totalAmount = 0;
            Long orderId = 0L;
            Payment payment = null;
            List<PurchasePaidEventAvroModel> collect = messages.stream().toList();
            for (PurchasePaidEventAvroModel purchasePaidEventAvroModel : collect) {
                totalAmount = purchasePaidEventAvroModel.getAmount();
                orderId = Long.valueOf(purchasePaidEventAvroModel.getPurchaseId());
                payment = paymentRepository.findByImpUid(purchasePaidEventAvroModel.getTransactionId())
                        .orElseThrow(() -> new PaymentDomainException("No paymentId"));
            }
            String userId = "memberId:" + purchase.getMember().getId();
            sseEmitterService.sendPaymentCompletedEventToUser(userId,
                    "주문이 성공적으로 완료되었습니다!", orderId, totalAmount, payment.getStatus());
        }
    }
}
