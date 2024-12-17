package com.green.sahwang.cart.dto.request.cart;

import lombok.Data;

@Data
public class ProductQuantityReqDto {

    private Long memberId;
    private Long productId;
    private int quantity;
}
