package com.green.sahwang.dto.request;

import lombok.Data;

@Data
public class CartProductsReqDto {

    private Long memberId;
    private Long productId;
    private int quantity;
}
