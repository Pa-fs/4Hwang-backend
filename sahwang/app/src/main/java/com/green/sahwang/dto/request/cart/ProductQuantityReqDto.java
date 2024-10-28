package com.green.sahwang.dto.request.cart;

import lombok.Data;

@Data
public class ProductQuantityReqDto {

    private Long memberId;
    private Long productId;
    private int quantity;
}
