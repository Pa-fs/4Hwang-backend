package com.green.sahwang.service;

import com.green.sahwang.dto.request.WishProductReqDto;
import com.green.sahwang.dto.response.WishCheckedResDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface WishService {
    List<WishCheckedResDto> getChecked(UserDetails userDetails, List<WishProductReqDto> wishProductReqDtoList);
    Boolean clickWish(UserDetails userDetails, Long productId);
}
