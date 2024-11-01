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

        DetailImagesResDto detailImagesResDto = productDetailPageService.getProductImages(productId);

        return ResponseEntity.ok(detailImagesResDto);
    }

    @GetMapping("/chart/{productId}")
    public ResponseEntity<List<DetailChartResDto>> productDetailPageChart(@PathVariable(name = "productId") Long productId,
                                                                          @RequestParam int size){

        List<DetailChartResDto> detailChartResDtoList = productDetailPageService.getSaleProducts(productId, size);

        return ResponseEntity.ok(detailChartResDtoList);
    }

    @GetMapping("/detailProductInfo/{productId}")
    public ResponseEntity<List<DetailProductInfoResDto>> getProductInfo(@PathVariable(name = "productId") Long productId){

        List<DetailProductInfoResDto> detailProductInfoResDtoList = productDetailPageService.getDetailProductInfo(productId);

        return ResponseEntity.ok(detailProductInfoResDtoList);
    }

    @GetMapping("/detailReviewInfo/{productId}")
    public ResponseEntity<DetailReviewInfoResDto> getReviewInfo(@PathVariable(name = "productId") Long productId){

        DetailReviewInfoResDto detailReviewInfoResDto = productDetailPageService.getDetailReviewInfo(productId);

        return ResponseEntity.ok(detailReviewInfoResDto);
    }

    @GetMapping("/detailPageImage/{productId}")
    public ResponseEntity<DetailImageResDto> getDetailPageImage(@PathVariable(name = "productId") Long productId){

        DetailImageResDto detailImageResDto = productDetailPageService.getDetailPageImage(productId);

        return ResponseEntity.ok(detailImageResDto);
    }

    @GetMapping("/review/{productId}")
    public ResponseEntity<List<ReviewResDto>> getReviewPage(@PathVariable(name = "productId") Long productID,
                                                            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "5", required = false) int size){
        List<ReviewResDto> reviewResDtoList = productDetailPageService.getReviewPages(productID, pageNum, size);

        return ResponseEntity.ok(reviewResDtoList);
    }

    @GetMapping("/favorite/{productId}")
    public ResponseEntity<List<FavoriteCheckedResDto>> favoriteCheck(@PathVariable(name = "productId") Long productId,
                                                                     @AuthenticationPrincipal UserDetails userDetails){
        List<FavoriteCheckedResDto> favoriteCheckedResDtoList = productDetailPageService.getChecked(productId, userDetails);

        return ResponseEntity.ok(favoriteCheckedResDtoList);
    }

    @GetMapping("/favorite/click/{reviewId}")
    public ResponseEntity<String> clickFavorite(@PathVariable(name = "reviewId") Long productId,
                                              @AuthenticationPrincipal UserDetails userDetails){
        productDetailPageService.clickFavorite(productId, userDetails);
        return ResponseEntity.ok("좋아요");
    }

    @GetMapping("/favorite/cancel/{reviewId}")
    public ResponseEntity<String> cancelFavorite(@PathVariable(name = "reviewId") Long reviewId,
                                               @AuthenticationPrincipal UserDetails userDetails){
        productDetailPageService.cancelFavorite(reviewId, userDetails);
        return ResponseEntity.ok("좋아요 취소");
    }

}