package com.green.sahwang.inspection.dto.request;

import com.green.sahwang.pendingsale.dto.request.UserSaleReqImageDto;
import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.verifiedsale.entity.SaleGrade;
import com.green.sahwang.verifiedsale.entity.enumtype.GradeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionPassReqDto {
    private Long pendingSaleId;
    private InspectionCategoryReqDto inspectionCategoryReqDto;
    private InspectionBrandReqDto inspectionBrandReqDto;
    private InspectionProductReqDto inspectionProductReqDto;
    private String seller;
    private GradeType gradeType;
    private boolean inspectionResult;
}
