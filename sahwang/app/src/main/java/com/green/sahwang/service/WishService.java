package com.green.sahwang.service;

import com.green.sahwang.dto.request.WishProductReqDto;
import com.green.sahwang.dto.response.WishCheckedResDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface WishService {
    List<WishCheckedResDto> getCheckedCategory(UserDetails userDetails, List<WishProductReqDto> wishProductReqDtoList);
    List<WishCheckedResDto> getCheckedProduct(UserDetails userDetails, List<WishProductReqDto> wishProductReqDtoList);
    Boolean clickWishCategory(UserDetails userDetails, Long productId);
    Boolean clickWishProduct(UserDetails userDetails, Long productId);
}
