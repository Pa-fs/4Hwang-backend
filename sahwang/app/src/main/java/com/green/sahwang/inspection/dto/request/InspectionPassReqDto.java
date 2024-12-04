package com.green.sahwang.inspection.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionPassReqDto {
    private Long pendingSaleId;
    private Long gradeId;
    private InspectionCategoryReqDto inspectionCategoryReqDto;
    private InspectionBrandReqDto inspectionBrandReqDto;
    private InspectionProductReqDto inspectionProductReqDto;
    private String seller;
    private String inspectionContent;
    private boolean inspectionResult;
}
