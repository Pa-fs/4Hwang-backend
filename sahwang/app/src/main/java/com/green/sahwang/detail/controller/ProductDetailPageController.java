package com.green.sahwang.detail.controller;

import com.green.sahwang.detail.dto.response.*;
import com.green.sahwang.detail.service.ProductDetailPageService;
import com.green.sahwang.dto.request.ImageFileReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @GetMapping("/detailProductInfo/{usedProductId}")
    public ResponseEntity<DetailProductInfoResDto> getProductInfo(@PathVariable(name = "usedProductId") Long usedProductId){

        DetailProductInfoResDto detailProductInfo = productDetailPageService.getDetailProductInfo(usedProductId);

        return ResponseEntity.ok(detailProductInfo);
    }

    @GetMapping("/detailReviewInfo/{usedProductId}")
    public ResponseEntity<DetailReviewInfoResDto> getReviewInfo(@PathVariable(name = "usedProductId") Long usedProductId){

        DetailReviewInfoResDto detailReviewInfoResDto = productDetailPageService.getDetailReviewInfo(usedProductId);

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

    @GetMapping("/detailPageImage/{usedProductId}")
    public ResponseEntity<DetailMainImageResDto> getDetailPageImage(@PathVariable(name = "usedProductId") Long usedProductId){

        DetailMainImageResDto detailMainImageResDto = productDetailPageService.getDetailMainPageImage(usedProductId);

        return ResponseEntity.ok(detailMainImageResDto);
    }

    @GetMapping("/review/{usedProductId}")
    public ResponseEntity<List<ReviewResDto>> getReviewPage(@PathVariable(name = "usedProductId") Long usedProductId,
                                                            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "5", required = false) int size){
        List<ReviewResDto> reviewResDtoList = productDetailPageService.getReviewPages(usedProductId, pageNum, size);

        return ResponseEntity.ok(reviewResDtoList);
    }

    @GetMapping("/reviewImageList/{usedProductId}")
    public ResponseEntity<List<ReviewImageResDto>> getReviewImages(@PathVariable(name = "usedProductId") Long usedProductId){

        List<ReviewImageResDto> reviewImageResDtoList = productDetailPageService.getReviewImages(usedProductId);

        return ResponseEntity.ok(reviewImageResDtoList);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "리뷰 도움되요", description = "리뷰 도움되유 리스트")
    @GetMapping("/favorite/{productId}")
    public ResponseEntity<List<FavoriteCheckedResDto>> favoriteCheck(@PathVariable(name = "usedProductId") Long usedProductId,
                                                                     @AuthenticationPrincipal UserDetails userDetails,
                                                                     @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                                     @RequestParam(name = "size", defaultValue = "5", required = false) int size){
        List<FavoriteCheckedResDto> favoriteCheckedResDtoList = productDetailPageService.getChecked(usedProductId, userDetails, pageNum, size);

        return ResponseEntity.ok(favoriteCheckedResDtoList);
    }

//    @GetMapping("/favorite/click/{reviewId}")
//    public ResponseEntity<FavoriteClickResDto> clickFavorite(@PathVariable(name = "reviewId") Long reviewId,
//                                              @AuthenticationPrincipal UserDetails userDetails){
//        FavoriteClickResDto favoriteClickResDto = productDetailPageService.clickFavorite(reviewId, userDetails);
//        return ResponseEntity.ok(favoriteClickResDto);
//    }
//
//    @GetMapping("/favorite/cancel/{reviewId}")
//    public ResponseEntity<FavoriteClickResDto> cancelFavorite(@PathVariable(name = "reviewId") Long reviewId,
//                                               @AuthenticationPrincipal UserDetails userDetails){
//        FavoriteClickResDto favoriteClickResDto = productDetailPageService.cancelFavorite(reviewId, userDetails);
//        return ResponseEntity.ok(favoriteClickResDto);
//    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "리뷰 도움되요 클릭", description = "리뷰 도움되유 클릭")
    @GetMapping("/favorite/clickFavorite/{reviewId}")
    public ResponseEntity<FavoriteClickResDto> clickFavorite(@AuthenticationPrincipal UserDetails userDetails,
                                                             @RequestParam(name = "reviewId") Long reviewId){
        FavoriteClickResDto favoriteClickResDto = productDetailPageService.clickFavorite(userDetails, reviewId);

        return ResponseEntity.ok(favoriteClickResDto);
    }

}