package com.green.sahwang.controller;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.service.category.CategoryBrandService;
import com.green.sahwang.service.impl.category.CategoryBrandResponse;
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
    public ResponseEntity<List<ProductResDto>> getProducts(
            @PathVariable(name = "categoryId") Long categoryId,
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "8") int size,
            @RequestParam(name = "sortType", defaultValue = "productionDate") String sortType) {
        List<ProductResDto> productResDtoList = categoryBrandService
                .getProductsByCategory(categoryId, pageNum, size, sortType);

        return ResponseEntity.ok(productResDtoList);
    }

    @GetMapping("/{categoryId}/brands-products")
    public ResponseEntity<CategoryBrandResponse> getBrandsAndProducts(
            @PathVariable(name = "categoryId") Long categoryId,
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "8") int size,
            @RequestParam(name = "sortType", defaultValue = "productionDate") String sortType) {
        CategoryBrandResponse response = categoryBrandService
                .getBrandsAndProductsByCategory(categoryId, pageNum, size, sortType);

        return ResponseEntity.ok(response);
    }
}
