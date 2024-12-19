package com.green.sahwang.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartProductPurchaseReadyResDto {
    private Long usedProductId;
    private String productName;
    private int price;
    private int quantity;
    private int size;
    private String content;
    private String mainImage;
}
