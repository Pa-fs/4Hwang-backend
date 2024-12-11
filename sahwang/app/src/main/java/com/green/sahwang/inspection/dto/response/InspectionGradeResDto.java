package com.green.sahwang.inspection.dto.response;

import com.green.sahwang.verifiedsale.entity.enumtype.GradeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InspectionGradeResDto {

    private Long gradeId;
    private GradeType gradeType;
    private String gradeDescription;
}
