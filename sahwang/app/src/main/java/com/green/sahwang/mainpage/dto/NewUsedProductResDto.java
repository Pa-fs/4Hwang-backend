package com.green.sahwang.mainpage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewUsedProductResDto {

    private Long usedProductId;
    private String brandName;
    private String productName;
    private int price;
    private int size;
    private String gradeType;
    private String registerDate;
    private String mainImage;
}
