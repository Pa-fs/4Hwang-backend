package com.green.sahwang.mypage.service;

import com.green.sahwang.mypage.dto.OrderProgressResDto;
import com.green.sahwang.mypage.dto.SaleProgressResDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface MyPageService {
    OrderProgressResDto getOrderProgress(UserDetails userDetails);

    SaleProgressResDto getSaleProgress(UserDetails userDetails);
}
