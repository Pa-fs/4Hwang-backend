package com.green.sahwang.controller;

import com.green.sahwang.dto.request.PurchaseReqDto;
import com.green.sahwang.dto.response.PurchaseResDto;
import com.green.sahwang.dto.response.externalapi.ExternalPaymentResDto;
import com.green.sahwang.service.PurchaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
@Slf4j
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping("/create")
//    public ResponseEntity<String> createPurchase(@RequestBody dto)
    public ResponseEntity<PurchaseResDto> createPurchase(@Valid @RequestBody PurchaseReqDto purchaseReqDto,
                                                         @AuthenticationPrincipal UserDetails userDetails) {

        log.info("PurchaseReqDto : {}", purchaseReqDto);
        PurchaseResDto purchaseResDto = purchaseService.createPurchase(purchaseReqDto, userDetails.getUsername());
        return ResponseEntity.ok(purchaseResDto);
    }

    @GetMapping("/purchaseCompleted")
    public ResponseEntity<ExternalPaymentResDto> purchaseCompleted(@RequestParam String merchant_uid) {
        ExternalPaymentResDto externalPaymentResDto = purchaseService.purchaseCompleted(merchant_uid);
        return ResponseEntity.ok(externalPaymentResDto);
    }
}
