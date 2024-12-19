package com.green.sahwang.dto.request.externalapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.sahwang.purchase.dto.request.PurchaseReqDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ExternalPurchasePaymentReqDto {
    private Long purchaseId;

    private String buyerEmail;

    private String buyerName;


    private String buyerAddr;

    private String buyerPostcode;

    private String buyerPhone;

    @NotNull
    @JsonProperty(value = "merchant_uid")
    private String merchantUId;

    @NotNull
    @JsonProperty(value = "imp_uid")
    private String impUid;

    @JsonProperty(value = "pay_method")
    private String payMethod;

    private BigDecimal amount;

    @NotEmpty
    private List<PurchaseReqDto.PurchaseProductReqDto> purchaseProductDtos;
}
