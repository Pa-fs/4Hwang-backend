package com.green.sahwang.mypage.controller;

import com.green.sahwang.mypage.dto.OrderProgressResDto;
import com.green.sahwang.mypage.dto.SaleProgressResDto;
import com.green.sahwang.mypage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("myPage")
@CrossOrigin
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("orderProgress")
    public ResponseEntity<OrderProgressResDto> getOrderProgress(@AuthenticationPrincipal UserDetails userDetails){

        OrderProgressResDto orderProgressResDto = myPageService.getOrderProgress(userDetails);

        return ResponseEntity.ok(orderProgressResDto);
    }

    @GetMapping("saleProgress")
    public ResponseEntity<SaleProgressResDto> getSaleProgress(@AuthenticationPrincipal UserDetails userDetails){

        SaleProgressResDto saleProgressResDto = myPageService.getSaleProgress(userDetails);

        return ResponseEntity.ok(saleProgressResDto);
    }

}
