package com.green.sahwang.cart.dto.request;

import lombok.Data;

@Data
public class CartUsedProductRemoveReqDto {

    private Long usedProductId;
    private int price;
    private int quantity;
}
