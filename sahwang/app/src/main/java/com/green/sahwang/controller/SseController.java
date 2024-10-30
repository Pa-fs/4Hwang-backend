package com.green.sahwang.controller;

import com.green.sahwang.service.SseEmitterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class SseController {

    private final SseEmitterService sseEmitterService;
    @GetMapping(value = "/payment/completed/subscriber", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public SseEmitter subscribe(@AuthenticationPrincipal UserDetails userDetails) {
//        return sseEmitterService.createEmitter(userDetails.getUsername());
//    }
    public SseEmitter subscribe() {
        return sseEmitterService.createEmitter("qordi124@gmail.com");
    }

}
