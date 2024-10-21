package com.green.sahwang.dto.response;

import com.green.sahwang.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductResponse {

    private Long productId;
    private String productName;
    private int price;
    private List<ImageResponse> images;

    public ProductResponse(Long productId, String productName, int price, List<ImageResponse> images) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.images = images;
    }
}
