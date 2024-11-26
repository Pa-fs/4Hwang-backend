package com.green.sahwang.mypage.service;

import com.green.sahwang.mypage.dto.res.OrderListResDto;
import com.green.sahwang.mypage.dto.res.OrderProgressResDto;
import com.green.sahwang.mypage.dto.res.SaleProgressResDto;
import com.green.sahwang.mypage.dto.res.WishListResDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface MyPageService {
    OrderProgressResDto getOrderProgress(UserDetails userDetails);

    SaleProgressResDto getSaleProgress(UserDetails userDetails);

    List<OrderListResDto> getOrderList(UserDetails userDetails, int pageNum, int size);

    List<WishListResDto> getWishList(UserDetails userDetails);
}
