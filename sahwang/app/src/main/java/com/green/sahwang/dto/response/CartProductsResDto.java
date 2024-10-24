package com.green.sahwang.dto.response;

import lombok.Data;

@Data
public class CartProductsResDto {
    private ProductResDto productResDto;
    private int quantity;

    public CartProductsResDto(ProductResDto productResDto, int quantity) {
        this.productResDto = productResDto;
        this.quantity = quantity;
    }
}
