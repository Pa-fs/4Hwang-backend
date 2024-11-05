package com.green.sahwang.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.sahwang.dto.event.OrderNotificationPayload;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.enumtype.PaymentStatus;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.yaml.snakeyaml.emitter.Emitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@RequiredArgsConstructor
@Slf4j
public class SseEmitterService {
    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
    private final MemberRepository memberRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public SseEmitter createEmitter(String email) {
        Member member = memberRepository.findByEmail(email);
        if (Objects.isNull(member)) {
            throw new BizException(ErrorCode.NO_MEMBER);
        }

        SseEmitter emitter = new SseEmitter();
        String userId = "memberId:" + member.getId();
        emitters.put(userId, emitter);

        log.info("new emitter added: {}", emitter);
        log.info("emitter list size: {}", emitters.size());
        log.info("emitter list: {}", emitters);

        emitter.onCompletion(() -> {
            log.info("onCompletion callback");
            emitters.remove(userId);
        });
        emitter.onTimeout(() -> { // 타임아웃 발생시 콜백 등록
            log.info("onTimeout callback");
            emitters.remove(userId);
        });

        return emitter;
    }

    public void sendPaymentCompletedEventToUser(String userId, String message, Long orderId, int totalAmount, PaymentStatus status) {
        SseEmitter emitter = emitters.get(userId);
        log.info("emitter exists ? : {}", emitter);
        if (emitter != null) {
            try {
                // OrderNotificationPayload 객체 생성
                OrderNotificationPayload payload = new OrderNotificationPayload(orderId, message, totalAmount, status);

                // SseEmitter로 JSON 형식의 데이터 전송
                emitter.send(SseEmitter.event()
                        .name("paymentCompletedEvent")
                        .data(objectMapper.writeValueAsString(payload))); // JSON 직렬화
                log.info("sendPaymentCompletedEventToUser notification send!!!");
            } catch (IOException e) {
                log.info("sendPaymentCompletedEventToUser send failed!!!");
                emitters.remove(userId);
            }
        }
    }
}
