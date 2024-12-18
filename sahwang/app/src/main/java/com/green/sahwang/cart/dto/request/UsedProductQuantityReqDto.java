package com.green.sahwang.cart.dto.request;

import lombok.Data;

@Data
public class UsedProductQuantityReqDto {

    private Long memberId;
    private Long usedProductId;
    private int quantity;
}
