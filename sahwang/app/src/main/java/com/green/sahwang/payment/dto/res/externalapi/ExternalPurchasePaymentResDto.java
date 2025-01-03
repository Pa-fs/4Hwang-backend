package com.green.sahwang.payment.dto.res.externalapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExternalPurchasePaymentResDto {
    @JsonProperty(value = "merchant_uid")
    private String merchantUId;
}
