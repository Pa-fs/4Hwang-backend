package com.green.sahwang.payment.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CancelPaymentReqDto {
    private String impUid; // 결제 고유 ID
    private String reason; // 취소 사유
}
