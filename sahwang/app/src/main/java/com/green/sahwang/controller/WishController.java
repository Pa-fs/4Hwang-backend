package com.green.sahwang.controller;

import com.green.sahwang.dto.request.WishProductReqDto;
import com.green.sahwang.dto.response.WishCheckedResDto;
import com.green.sahwang.service.WishService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wish")
@RequiredArgsConstructor
public class WishController {

    private final WishService wishService;

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "카테고리 찜하기", description = "카테고리 찜하기")
    @PostMapping("/category")
    public ResponseEntity<List<WishCheckedResDto>> wishCategoryCheck(@AuthenticationPrincipal UserDetails userDetails,
                                                             @RequestBody List<WishProductReqDto> wishProductReqDtoList){

        List<WishCheckedResDto> wishCheckedResDtoList = wishService.getCheckedCategory(userDetails, wishProductReqDtoList);

        return ResponseEntity.ok(wishCheckedResDtoList);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "상품 찜하기", description = "상품 찜하기")
    @PostMapping("/product")
    public ResponseEntity<List<WishCheckedResDto>> wishProductCheck(@AuthenticationPrincipal UserDetails userDetails,
                                                                    @RequestBody List<WishProductReqDto> wishProductReqDtoList){
        List<WishCheckedResDto> wishCheckedResDtoList = wishService.getCheckedProduct(userDetails, wishProductReqDtoList);

        return ResponseEntity.ok(wishCheckedResDtoList);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/category/click")
    @Operation(summary = "카테고리 찜하기 클릭", description = "카테고리 찜하기 클릭")
    public ResponseEntity<String> updateWishCategory(@AuthenticationPrincipal UserDetails userDetails,
                                             @RequestBody Long productId){
        Boolean isWished = wishService.clickWishCategory(userDetails, productId);

        return ResponseEntity.ok(isWished ? "찜하기 추가" : "찜하기 취소");
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/product/click")
    @Operation(summary = "상품 찜하기 클릭", description = "상품 찜하기 클릭")
    public ResponseEntity<String> updateWishProduct(@AuthenticationPrincipal UserDetails userDetails,
                                             @RequestBody Long productId){
        Boolean isWished = wishService.clickWishProduct(userDetails, productId);

        return ResponseEntity.ok(isWished ? "찜하기 추가" : "찜하기 취소");
    }

}
