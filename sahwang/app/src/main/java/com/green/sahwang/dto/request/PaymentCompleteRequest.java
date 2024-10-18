package com.green.sahwang.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentCompleteRequest {
    private String purchaseId;
    private String imp_uid;
    private String merchant_uid;
    private String paid_amount;
    private String apply_num;
    private String email;
}
