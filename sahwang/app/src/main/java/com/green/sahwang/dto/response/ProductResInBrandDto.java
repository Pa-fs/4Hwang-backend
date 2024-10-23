package com.green.sahwang.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductResInBrandDto {

    private Long productId;
    private String productName;
    private int price;
    private List<ImageResDto> images;

    public ProductResInBrandDto(Long productId, String productName, int price, List<ImageResDto> images) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.images = images;
    }
}
