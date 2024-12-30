package com.green.sahwang.inspection.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionProductReqDto {
    private Long productId;
    private String productName;
    private int productSize;
    private int verifiedSellingPrice;
    private int quantity;
}
