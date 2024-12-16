package com.green.sahwang.inspection.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailSaleReqImageDto {
    private Long verifiedSaleId;
    private String name;
    private String path;
    private String desc;
}
