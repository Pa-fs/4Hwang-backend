package com.green.sahwang.controller;

import com.green.sahwang.security.filter.JWTUtils;
import com.green.sahwang.service.SseEmitterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class SseController {

    private final SseEmitterService sseEmitterService;
    private final JWTUtils jwtUtils;

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "결제 완료 알림", description = "결제 후 회원에게 알림 전송")
    @GetMapping(value = "/payment/completed/subscriber", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(@RequestParam("token") String token) {
        if (!jwtUtils.isValidAccessToken(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
        }

        String username = jwtUtils.getEmailFromJwt(token);
        if (username == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
        }

        return sseEmitterService.createEmitter(username);
    }
}
