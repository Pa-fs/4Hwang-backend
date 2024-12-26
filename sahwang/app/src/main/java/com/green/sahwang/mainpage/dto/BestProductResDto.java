package com.green.sahwang.mainpage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BestProductResDto {
    private Long productId;
    private Long brandId;
    private String dtype;
    private String brandName;
    private String productName;
    private String mainImage;
}
