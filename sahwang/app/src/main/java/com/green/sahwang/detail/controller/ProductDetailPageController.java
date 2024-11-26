package com.green.sahwang.detail.controller;

import com.green.sahwang.detail.dto.response.*;
import com.green.sahwang.detail.service.ProductDetailPageService;
import com.green.sahwang.dto.request.ImageFileReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<List<DetailChartResDto>> productDetailPageChart(@PathVariable(name = "productId") Long productId){

        List<DetailChartResDto> detailChartResDtoList = productDetailPageService.getSaleProducts(productId);

        return ResponseEntity.ok(detailChartResDtoList);
    }

    @GetMapping("/chart/oneMonth/{productId}")
    public ResponseEntity<List<DetailChartResDto>> productDetailPageChartOneMonth(@PathVariable(name = "productId") Long productId){

        List<DetailChartResDto> detailChartResDtoList = productDetailPageService.getChartOneMonth(productId);

        return ResponseEntity.ok(detailChartResDtoList);
    }

    @GetMapping("/chart/sixMonth/{productId}")
    public ResponseEntity<List<DetailChartResDto>> productDetailPageChartSixMonth(@PathVariable(name = "productId") Long productId){

        List<DetailChartResDto> detailChartResDtoList = productDetailPageService.getChartSixMonth(productId);

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

    @PostMapping(value = "/detailPageImage/upload",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadDetailPageImage(@RequestPart(name = "file") MultipartFile file,
                                        @RequestPart(name = "fileDto") ImageFileReqDto imageFileReqDto){
        productDetailPageService.saveDetailMainImage(file, imageFileReqDto);

        return "이미지 저장 완료되었습니다";
    }

    @GetMapping("/detailPageImage/{productId}")
    public ResponseEntity<DetailMainImageResDto> getDetailPageImage(@PathVariable(name = "productId") Long productId){

        DetailMainImageResDto detailMainImageResDto = productDetailPageService.getDetailMainPageImage(productId);

        return ResponseEntity.ok(detailMainImageResDto);
    }

    @GetMapping("/review/{productId}")
    public ResponseEntity<List<ReviewResDto>> getReviewPage(@PathVariable(name = "productId") Long productID,
                                                            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "5", required = false) int size){
        List<ReviewResDto> reviewResDtoList = productDetailPageService.getReviewPages(productID, pageNum, size);

        return ResponseEntity.ok(reviewResDtoList);
    }

    @GetMapping("/reviewImageList/{productId}")
    public ResponseEntity<List<ReviewImageResDto>> getReviewImages(@PathVariable(name = "productId") Long productId){

        List<ReviewImageResDto> reviewImageResDtoList = productDetailPageService.getReviewImages(productId);

        return ResponseEntity.ok(reviewImageResDtoList);
    }

    @GetMapping("/favorite/{productId}")
    public ResponseEntity<List<FavoriteCheckedResDto>> favoriteCheck(@PathVariable(name = "productId") Long productId, @AuthenticationPrincipal UserDetails userDetails){
        List<FavoriteCheckedResDto> favoriteCheckedResDtoList = productDetailPageService.getChecked(productId, userDetails);

        return ResponseEntity.ok(favoriteCheckedResDtoList);
    }

    @GetMapping("/favorite/click/{reviewId}")
    public ResponseEntity<FavoriteClickResDto> clickFavorite(@PathVariable(name = "reviewId") Long reviewId,
                                              @AuthenticationPrincipal UserDetails userDetails){
        FavoriteClickResDto favoriteClickResDto = productDetailPageService.clickFavorite(reviewId, userDetails);
        return ResponseEntity.ok(favoriteClickResDto);
    }

    @GetMapping("/favorite/cancel/{reviewId}")
    public ResponseEntity<FavoriteClickResDto> cancelFavorite(@PathVariable(name = "reviewId") Long reviewId,
                                               @AuthenticationPrincipal UserDetails userDetails){
        FavoriteClickResDto favoriteClickResDto = productDetailPageService.cancelFavorite(reviewId, userDetails);
        return ResponseEntity.ok(favoriteClickResDto);
    }

}