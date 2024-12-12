package com.green.sahwang.controller;

import com.green.sahwang.dto.request.WishProductReqDto;
import com.green.sahwang.dto.response.WishCheckedResDto;
import com.green.sahwang.service.WishService;
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
    @PostMapping
    public ResponseEntity<List<WishCheckedResDto>> wishCheck(@AuthenticationPrincipal UserDetails userDetails,
                                                             @RequestBody List<WishProductReqDto> wishProductReqDtoList){

//        System.out.println("권한 확인 시작");
//        userDetails.getAuthorities().stream().forEach(grantedAuthority ->
//                        System.out.println(grantedAuthority.getAuthority().toString())
//
//        );
//        System.out.println("권한 확인 끝");

        List<WishCheckedResDto> wishCheckedResDtoList = wishService.getChecked(userDetails, wishProductReqDtoList);

        return ResponseEntity.ok(wishCheckedResDtoList);
    }

    @PostMapping("/click")
    public ResponseEntity<String> updateWish(@AuthenticationPrincipal UserDetails userDetails,
                                             @RequestBody Long productId){
        Boolean isWished = wishService.clickWish(userDetails, productId);

        return ResponseEntity.ok(isWished ? "찜하기 추가" : "찜하기 취소");
    }

}
