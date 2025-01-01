package com.green.sahwang.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductForUsedResDto {

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

    private int minPrice;

    private int maxPrice;

    private int minSize;

    private int maxSize;

    private String gradeTypes;

    private int rankNumber;

    public ProductForUsedResDto(Long productId,
                                String productName,
                                String content,
                                String dtype,
                                String brandName,
                                int productSize,
                                int price,
                                int reviewCount,
                                String registerDate,
                                ImageResDto mainImage,
                                List<ImageResDto> images,
                                int minPrice,
                                int maxPrice,
                                int minSize,
                                int maxSize,
                                String gradeTypes,
                                int rankNumber) {
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
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.gradeTypes = gradeTypes;
        this.rankNumber = rankNumber;
    }
}
