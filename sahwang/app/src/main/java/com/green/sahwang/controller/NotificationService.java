package com.green.sahwang.controller;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Payment;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.exception.payment.PaymentDomainException;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.PaymentRepository;
import com.green.sahwang.service.SseEmitterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final MemberRepository memberRepository;
    private final SseEmitterService sseEmitterService;
    private final PaymentRepository paymentRepository;

    public void paymentCompletedUniCast(List<String> memberIds, List<PurchasePaidEventAvroModel> messages) {
        for (String memberId : memberIds) {
            String memberKeyId = memberId.split(":")[1];
            log.info("memberKeyId = {}", memberKeyId);
            Member member = memberRepository.findById(Long.valueOf(memberKeyId))
                    .orElseThrow(() -> new BizException(ErrorCode.NO_MEMBER));

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

            sseEmitterService.sendPaymentCompletedEventToUser(String.valueOf(member.getId()),
                    "주문이 성공적으로 완료되었습니다!", orderId, totalAmount, payment.getStatus());
        }
    }
}
