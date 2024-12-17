package com.green.sahwang.controller;

import com.green.sahwang.dto.response.ProductForUsedResDto;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.service.category.CategoryBrandService;
import com.green.sahwang.dto.response.CategoryBrandResDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryBrandController {

    private final CategoryBrandService categoryBrandService;

    @GetMapping("/{categoryId}")
    @Operation(summary = "카테고리 리스트 조회", description = "대카테고리 기준(향수, 디퓨저, 캔들)")
    public ResponseEntity<List<ProductForUsedResDto>> getProducts(
            @PathVariable(name = "categoryId") Long categoryId,
            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(name = "size", defaultValue = "8", required = false) int size,
            @RequestParam(name = "sortType", defaultValue = "production_date", required = false) String sortType) {
        List<ProductForUsedResDto> productResDtoList = categoryBrandService
                .getProductsByCategory(categoryId, pageNum, size, sortType);

        return ResponseEntity.ok(productResDtoList);
    }

    @GetMapping("/{categoryId}/brands-products")
    @Operation(summary = "사용안함", description = "")
    public ResponseEntity<CategoryBrandResDto> getBrandsAndProducts(
            @PathVariable(name = "categoryId") Long categoryId,
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "8") int size,
            @RequestParam(name = "sortType", defaultValue = "productionDate") String sortType) {
        CategoryBrandResDto response = categoryBrandService
                .getBrandsAndProductsByCategory(categoryId, pageNum, size, sortType);

        return ResponseEntity.ok(response);
    }
}
