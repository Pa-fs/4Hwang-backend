package com.green.sahwang.detail.dto;

import com.green.sahwang.verifiedsale.entity.enumtype.GradeType;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailProductInfoDto {
    private Long usedProductId;
    private Long productId;
    private String brandName;
    private String productName;
    private int size;
    private int productSize;
    private int verifiedSellingPrice;
    private GradeType gradeType;
}
