package com.green.sahwang.dto.request.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartProductsReqDto {

//    private Long memberId; // 제거 예정
    private Long productId;
    private int quantity;
}
