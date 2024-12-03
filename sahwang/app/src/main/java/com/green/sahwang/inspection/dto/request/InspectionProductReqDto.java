package com.green.sahwang.inspection.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionProductReqDto {
    private String productName;
    private int productSize;
    private String productContent;
    private int verifiedSellingPrice;
    private int quantity;
}
