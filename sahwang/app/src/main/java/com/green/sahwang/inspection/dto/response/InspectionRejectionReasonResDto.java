package com.green.sahwang.inspection.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InspectionRejectionReasonResDto {
    private Long rejectionReasonId;
    private String rejectionReason;
}
