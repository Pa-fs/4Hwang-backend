package com.green.sahwang.cart.dto.request.cart;

import lombok.Data;

@Data
public class CartProductsRemoveReqDto {

    private Long productId;
    private int price;
    private int quantity;
}
