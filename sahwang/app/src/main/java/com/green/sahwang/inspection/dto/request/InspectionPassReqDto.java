package com.green.sahwang.inspection.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionPassReqDto {
    private String productName;
    private String size;
    private int quantity;
}
