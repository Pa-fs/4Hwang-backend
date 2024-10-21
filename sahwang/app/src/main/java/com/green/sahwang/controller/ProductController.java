package com.green.sahwang.controller;

import com.green.sahwang.dto.response.BestProductResDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/best")
    public ResponseEntity<BestProductResDto> bestProduct(){

        return null;
    }


}
