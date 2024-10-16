package com.green.sahwang.controller;

import com.green.sahwang.service.PurchaseService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping("/create")
//    public ResponseEntity<String> createPurchase(@RequestBody dto)
    public ResponseEntity<String> createPurchase(@RequestParam String dto) {
        System.out.println("ddd " +dto);
        // memberId, List<Product> products.
        purchaseService.createPurchase(dto);
        return ResponseEntity.ok("succcess");
    }
}
