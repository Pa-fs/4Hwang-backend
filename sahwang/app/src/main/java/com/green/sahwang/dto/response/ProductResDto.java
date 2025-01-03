package com.green.sahwang.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(value = "size")
    private int productSize;

    private int price;

    // review Service 만들어서
    private int reviewCount;

    private String registerDate;

    private ImageResDto mainImage;

    private List<ImageResDto> images;

    public ProductResDto(Long productId,
                         String productName,
                         String content,
                         String dtype,
                         String brandName,
                         int productSize,
                         int price,
                         int reviewCount,
                         String registerDate,
                         ImageResDto mainImage,
                         List<ImageResDto> images) {
        this.productId = productId;
        this.productName = productName;
        this.content = content;
        this.dtype = dtype;
        this.brandName = brandName;
        this.productSize = productSize;
        this.price = price;
        this.reviewCount = reviewCount;
        this.registerDate = registerDate;
        this.mainImage = mainImage;
        this.images = images;
    }
}
