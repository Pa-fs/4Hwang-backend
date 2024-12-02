package com.green.sahwang.brand.controller;

import com.green.sahwang.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
@Slf4j
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandSerivce;

    @GetMapping("/search")
    public ResponseEntity<?> searchBrands(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(brandSerivce.searchBrands(keyword));
    }
}
