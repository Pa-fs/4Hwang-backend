package com.green.sahwang.controller;

import com.green.sahwang.dto.request.PaymentCompleteRequest;
import com.green.sahwang.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<String> createPaid(@ModelAttribute PaymentCompleteRequest paymentCompleteRequest) {
        log.info("paymentCompleteRequest = {}", paymentCompleteRequest.toString());
        paymentService.processAsyncPayment(paymentCompleteRequest);
        return ResponseEntity.ok("결제완료 처리 중");
    }
}
