package com.green.sahwang.mypage.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApproveVerifiedSaleReqDto {
    private Long pendingSaleId;
    private int salesPrice;
}
