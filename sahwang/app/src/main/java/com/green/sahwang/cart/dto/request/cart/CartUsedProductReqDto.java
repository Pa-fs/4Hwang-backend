package com.green.sahwang.cart.dto.request.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartUsedProductReqDto {

    private Long usedProductId;
    private int quantity;
}
