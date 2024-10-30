package com.green.sahwang.detail.controller;

import com.green.sahwang.detail.dto.response.DetailChartResDto;
import com.green.sahwang.detail.dto.response.DetailImagesResDto;
import com.green.sahwang.detail.dto.response.DetailReviewResDto;
import com.green.sahwang.detail.service.ProductDetailPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
