package com.green.sahwang.payment.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentCompleteRequest {
    private String purchaseId;
    @JsonProperty(value = "imp_uid")
    private String impUid;
    @JsonProperty(value = "merchant_uid")
    private String merchantUid;
    @JsonProperty(value = "paid_amount")
    private BigDecimal paidAmount;
    @JsonProperty(value = "apply_num")
    private String applyNum;
    private String email;
}
