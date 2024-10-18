package com.green.sahwang.dto.request;

import lombok.Data;

@Data
public class PurchaseReqDto {
    private Long memberId;
    // 결제 예정 금액
    private Long totalPrice;
}
