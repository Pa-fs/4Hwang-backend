package com.green.sahwang.controller;

import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.model.payment.avro.PaymentStatus;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.green.sahwang.controller.SseEmitters.SSE_EMITTERS;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final PurchaseRepository purchaseRepository;

    public void broadCast(List<String> purchaseIds, List<PurchasePaidEventAvroModel> messages) {
        for (String purchaseId : purchaseIds) {
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            Purchase purchase = purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));

            // Idempotency
            purchase.validatePaidStatus();

            List<SseEmitter> deadEmitters = new ArrayList<>();
            for (SseEmitter emitter : SSE_EMITTERS) {
                try {
                    emitter.send(SseEmitter.event().name("paidCompleted")
                            .data(purchase.getPurchaseStatus()));
                } catch (IOException e) {
                    deadEmitters.add(emitter);
                }
            }
            SSE_EMITTERS.removeAll(deadEmitters);
        }
    }
}
