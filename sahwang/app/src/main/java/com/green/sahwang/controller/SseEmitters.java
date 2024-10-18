package com.green.sahwang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
public class SseEmitters {

    public final static List<SseEmitter> SSE_EMITTERS = new CopyOnWriteArrayList<>();

    SseEmitter add(SseEmitter sseEmitter) {
        this.SSE_EMITTERS.add(sseEmitter);
        log.info("new emitter added: {}", sseEmitter);
        log.info("emitter list size: {}", SSE_EMITTERS.size());
//        log.info("emitter list: {}", sseEmitters);

        sseEmitter.onCompletion(() -> {
            log.info("onCompletion callback");
            this.SSE_EMITTERS.remove(sseEmitter); // 만료되면 리스트에서 삭제
        });
        sseEmitter.onTimeout(() -> { // 타임아웃 발생시 콜백 등록
            log.info("onTimeout callback");
            sseEmitter.complete();
        });

        return sseEmitter;
    }
}
