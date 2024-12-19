package com.green.sahwang.purchase.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseResDto {
    private Long purchaseId;
    private Long memberId;
}
