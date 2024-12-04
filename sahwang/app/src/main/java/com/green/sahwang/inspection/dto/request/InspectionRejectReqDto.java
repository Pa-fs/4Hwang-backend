package com.green.sahwang.inspection.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionRejectReqDto {
    private Long pendingSaleId;
    private Long rejectionReasonId;
    private InspectionCategoryReqDto inspectionCategoryReqDto;
    private InspectionBrandReqDto inspectionBrandReqDto;
    private InspectionProductReqDto inspectionProductReqDto;
    private String seller;
    private String inspectionContent;
    private String rejectionReason;
    private boolean inspectionResult;
}
