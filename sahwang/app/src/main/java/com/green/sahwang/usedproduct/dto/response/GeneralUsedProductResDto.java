package com.green.sahwang.usedproduct.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.sahwang.dto.response.ImageResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneralUsedProductResDto {
    private Long usedProductId;

    private Long productId;

    private String productName;

    private String nickName;

    private String brandName;

    private String dtype;

    private boolean usedOrNot;

    private String verifiedSaleGradeType;

    @JsonProperty(value = "size")
    private int sellingUsedProductSize;

    private int sellingPrice;

    // review Service 만들어서
    private int reviewCount;

    private String registerDate;

    private List<ImageResDto> images;
}
