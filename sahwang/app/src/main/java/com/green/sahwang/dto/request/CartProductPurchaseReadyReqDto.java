package com.green.sahwang.dto.request;

import lombok.Data;

@Data
public class CartProductPurchaseReadyReqDto {
    private Long productId;
    private int quantity;
}
