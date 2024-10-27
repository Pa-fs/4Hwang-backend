package com.green.sahwang.dto.response.externalapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExternalPurchasePaymentResDto {
    @JsonProperty(value = "merchant_uid")
    private String merchantUId;
}
