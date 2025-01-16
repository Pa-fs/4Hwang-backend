package com.green.sahwang.payment.dto.req.externalapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExternalPrePaymentReqDto {

    @JsonProperty(value = "merchant_uid")
    private String merchantUid;
    private BigDecimal amount;
    private Long purchaseId;
}
