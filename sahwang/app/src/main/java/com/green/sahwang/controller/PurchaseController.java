package com.green.sahwang.controller;

import com.green.sahwang.dto.request.PurchaseReqDto;
import com.green.sahwang.dto.response.PurchaseResDto;
import com.green.sahwang.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
@CrossOrigin
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping("/create")
//    public ResponseEntity<String> createPurchase(@RequestBody dto)
    public ResponseEntity<PurchaseResDto> createPurchase(@RequestBody PurchaseReqDto purchaseReqDto) {
        System.out.println("ddd " + purchaseReqDto.getMemberId());
        // memberId, List<Product> products.
        return ResponseEntity.ok(purchaseService.createPurchase(purchaseReqDto));
    }
}
