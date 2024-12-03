package com.green.sahwang.verifiedsale.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/verifiedSale")
@RequiredArgsConstructor
public class VerifiedSaleController {


    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "판매현황 조회 API", description = "JWT 포함, 사용자 마이페이지에서 판매현황 보기")
    @GetMapping("/list")
    public ResponseEntity<?> getVerifiedSaleList(
            @AuthenticationPrincipal UserDetails userDetails) {

        return ResponseEntity.ok(null);
    }

}
