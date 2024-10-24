package com.green.sahwang.dto.response;

import com.green.sahwang.config.DateTimeUtils;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductResDto {

    private Long productId;

    private String productName;

    private String content;

    private String dtype;

    private String brandName;

    private int price;

    // review Service 만들어서
    private int reviewCount;

    private String registerDate;

    private List<ImageResDto> images;

    public ProductResDto(Long productId,
                         String productName,
                         String content,
                         String dtype,
                         String brandName,
                         int price,
                         int reviewCount,
                         String registerDate,
                         List<ImageResDto> images) {
        this.productId = productId;
        this.productName = productName;
        this.content = content;
        this.dtype = dtype;
        this.brandName = brandName;
        this.price = price;
        this.reviewCount = reviewCount;
        this.registerDate = registerDate;
        this.images = images;
    }
}
