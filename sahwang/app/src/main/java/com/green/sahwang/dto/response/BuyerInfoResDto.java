package com.green.sahwang.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.sahwang.entity.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyerInfoResDto {

    @JsonProperty(value = "buyer_email")
    private String buyerEmail;
    @JsonProperty(value = "buyer_name")
    private String buyerName;
    @JsonProperty(value = "buyer_tel")
    private String buyerTel;
    private Address buyerAddress;
}
