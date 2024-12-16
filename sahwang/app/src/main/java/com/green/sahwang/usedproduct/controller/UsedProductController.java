package com.green.sahwang.usedproduct.controller;

import com.green.sahwang.usedproduct.dto.response.UsedProductResDto;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.service.UsedProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/used-product")
@RequiredArgsConstructor
public class UsedProductController {

    private final UsedProductService usedProductService;

    @GetMapping("/list/{productId}")
    @Operation(summary = "중고제품 조회 API", description = "제품 클릭 시 중고제품 리스트")
    public ResponseEntity<List<UsedProductResDto>> getUsedProductList(
            @PathVariable(value = "productId") Long productId,
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "6") int size,
            @RequestParam(name = "sortType", defaultValue = "createdDate", required = false) String sortType) {
        return ResponseEntity.ok(usedProductService.getUsedProducts(productId, pageNum, size, sortType));
    }
}
