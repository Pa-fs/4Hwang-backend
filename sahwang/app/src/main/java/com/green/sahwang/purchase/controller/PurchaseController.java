package com.green.sahwang.purchase.controller;

import com.green.sahwang.purchase.dto.request.PurchaseReqDto;
import com.green.sahwang.purchase.dto.response.PurchaseResDto;
import com.green.sahwang.dto.response.externalapi.ExternalPaymentResDto;
import com.green.sahwang.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "구매번호 생성", description = "장바구니에서 주문하기 시 번호 채번되며 사전검증까지 제공")
    @PostMapping("/create")
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
