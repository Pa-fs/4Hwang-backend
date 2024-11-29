package com.green.sahwang.inspection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionReqDto {
    private String productName;
    private String size;
    private int quantity;
}
