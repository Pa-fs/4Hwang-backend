package com.green.sahwang.mypage.controller;

import com.green.sahwang.mypage.dto.OrderProgressResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mypage")
@CrossOrigin
public class MyPageController {

    @GetMapping
    public ResponseEntity<OrderProgressResDto> getOrderProgress(@AuthenticationPrincipal UserDetails userDetails){

        return null;
    }

}
