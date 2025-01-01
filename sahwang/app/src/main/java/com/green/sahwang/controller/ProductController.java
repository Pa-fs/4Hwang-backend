package com.green.sahwang.controller;

import com.green.sahwang.dto.response.ProductForUsedResDto;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.mainpage.dto.BestProductResDto;
import com.green.sahwang.mainpage.dto.NewUsedProductResDto;
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
    public ResponseEntity<List<BestProductResDto>> bestProduct() {
        List<BestProductResDto> bestProducts = productService.getBestProducts();
        return ResponseEntity.ok(bestProducts);
    }

    @GetMapping("/random")
    public ResponseEntity<List<ProductForUsedResDto>> getRandomProducts(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "8") int size) {
        List<ProductForUsedResDto> products = productService.getRandomProducts(pageNum, size);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/new")
    public ResponseEntity<List<NewUsedProductResDto>> getNewProducts(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(productService.getNewProducts(pageNum, size));
    }

//    @GetMapping("/heart")
//    public ResponseEntity<List<HeartResDto>> checkedHeart(@AuthenticationPrincipal UserDetails userDetails){
//
//    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResDto>> search(@RequestParam("searchQuery") String keyword) {
        List<ProductResDto> products = productService.searchProducts(keyword);
        return ResponseEntity.ok(products);
    }
}
