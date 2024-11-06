package com.green.sahwang.controller;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.service.category.CategoryBrandService;
import com.green.sahwang.dto.response.CategoryBrandResDto;
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
            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(name = "size", defaultValue = "8", required = false) int size,
            @RequestParam(name = "sortType", defaultValue = "productionDate", required = false) String sortType) {
        List<ProductResDto> productResDtoList = categoryBrandService
                .getProductsByCategory(categoryId, pageNum, size, sortType);

        return ResponseEntity.ok(productResDtoList);
    }

    @GetMapping("/{categoryId}/brands-products")
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
