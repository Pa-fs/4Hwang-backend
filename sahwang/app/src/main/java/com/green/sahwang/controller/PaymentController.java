package com.green.sahwang.controller;

import com.green.sahwang.dto.request.PaymentCompleteRequest;
import com.green.sahwang.dto.request.externalapi.ExternalPaymentReqDto;
import com.green.sahwang.dto.request.externalapi.ExternalPurchasePaymentReqDto;
import com.green.sahwang.entity.externalapi.ExternalPrePaymentReqDto;
import com.green.sahwang.service.PaymentService;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/prepare")
    public void preparePayment(@RequestBody ExternalPrePaymentReqDto externalPrePaymentReqDto)
            throws IamportResponseException, IOException {

        log.info("ExternalPrePaymentReqDto : {}", externalPrePaymentReqDto);
        paymentService.prepareForPost(externalPrePaymentReqDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<Payment> validatePayment(@RequestBody PaymentCompleteRequest paymentCompleteRequest) throws IamportResponseException, IOException {
        log.info("paymentCompleteRequest = {}", paymentCompleteRequest.toString());
        Payment payment = paymentService.postValidateOrder(paymentCompleteRequest);
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/save-user-info")
    public ResponseEntity<String> saveUserInfo(@RequestBody ExternalPaymentReqDto externalPaymentReqDto) {
        paymentService.saveUserInfoForPayment(externalPaymentReqDto);
        return ResponseEntity.ok("success save user info");
    }

    @PostMapping("/save-purchase-info")
    public ResponseEntity<String> savePurchaseInfo(@RequestBody ExternalPurchasePaymentReqDto externalPurchasePaymentReqDto) {
        paymentService.savePurchaseInfoForPayment(externalPurchasePaymentReqDto);
        return ResponseEntity.ok(externalPurchasePaymentReqDto.getMerchantUId());
    }

    // Todo 현재 사용 안함
//    @PostMapping("/create")
//    public ResponseEntity<String> createPaid(@ModelAttribute PaymentCompleteRequest paymentCompleteRequest) {
//        paymentService.processAsyncPayment(paymentCompleteRequest);
//        return ResponseEntity.ok("결제완료 처리 중");
//    }
}
