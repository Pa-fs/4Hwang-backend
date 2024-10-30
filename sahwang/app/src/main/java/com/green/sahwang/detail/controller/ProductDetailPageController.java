package com.green.sahwang.detail.controller;

import com.green.sahwang.detail.dto.response.*;
import com.green.sahwang.detail.service.ProductDetailPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("detail")
@RequiredArgsConstructor
@Slf4j
public class ProductDetailPageController {

    @Autowired
    private ProductDetailPageService productDetailPageService;

    @GetMapping("/images/{productId}")
    public ResponseEntity<DetailImagesResDto> productDetailPageImages(@PathVariable(name = "productId") Long productId){
        log.info("productId {}", productId);
        DetailImagesResDto detailImagesResDto = productDetailPageService.getProductImages(productId);

        return ResponseEntity.ok(detailImagesResDto);
    }

    @GetMapping("/chart/{productId}")
    public ResponseEntity<List<DetailChartResDto>> productDetailPageChart(@PathVariable(name = "productId") Long productId){

        List<DetailChartResDto> detailChartResDtoList = productDetailPageService.getSaleProducts(productId);

        return ResponseEntity.ok(detailChartResDtoList);
    }

    // 필요할꺼 같은 정보들
    @GetMapping("/info/{productId}")
    public ResponseEntity<DetailReviewResDto> getReviewInfo(@PathVariable(name = "productId") Long productId){

        DetailReviewResDto detailReviewResDto = productDetailPageService.getDetailReviewInfo(productId);

        return ResponseEntity.ok(detailReviewResDto);
    }

    @GetMapping("/review/{productId}")
    public ResponseEntity<List<ReviewResDto>> getReviewPage(@PathVariable(name = "productId") Long productID,
                                                            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "3", required = false) int size){
        List<ReviewResDto> reviewResDtoList = productDetailPageService.getReviewPages(productID, pageNum, size);

        return ResponseEntity.ok(reviewResDtoList);
    }

    @GetMapping("/favorite/{productId}")
    public ResponseEntity<List<FavoriteCheckedResDto>> favoriteCheck(@PathVariable(name = "productId") Long productId,
                                                                     @AuthenticationPrincipal UserDetails userDetails){
        List<FavoriteCheckedResDto> favoriteCheckedResDtoList = productDetailPageService.getChecked(productId, userDetails);

        return ResponseEntity.ok(favoriteCheckedResDtoList);
    }

}
