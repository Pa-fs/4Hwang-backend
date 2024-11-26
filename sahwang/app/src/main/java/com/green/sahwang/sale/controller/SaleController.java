package com.green.sahwang.sale.controller;

import com.green.sahwang.sale.dto.SaleCreateReqDto;
import com.green.sahwang.sale.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping("/create")
    public ResponseEntity<String> createSale(@RequestBody SaleCreateReqDto saleCreatedDto,
                                             @AuthenticationPrincipal UserDetails userDetails) {

        saleService.createSale(saleCreatedDto, userDetails.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body("A sale was created");
    }
}
