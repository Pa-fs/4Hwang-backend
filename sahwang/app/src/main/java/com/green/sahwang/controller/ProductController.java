package com.green.sahwang.controller;

import com.green.sahwang.dto.response.BestProductResDto;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/best")
    public ResponseEntity<BestProductResDto> bestProduct() {

        return null;
    }

    @GetMapping("/random")
    public ResponseEntity<List<ProductResDto>> getRandomProducts(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "8") int size) {
        List<ProductResDto> products = productService.getRandomProducts(pageNum, size);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/new")
    public ResponseEntity<List<ProductResDto>> getNewProducts(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        List<ProductResDto> products = productService.getNewProducts(pageNum, size);
        return ResponseEntity.ok(products);
    }
}
