package com.green.sahwang.payment.dto.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.sahwang.entity.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyerInfoResDto {

    private String buyerEmail;
    private String buyerName;
    private String buyerTel;
    private Address buyerAddress;
}
