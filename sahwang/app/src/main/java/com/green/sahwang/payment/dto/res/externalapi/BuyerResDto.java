package com.green.sahwang.payment.dto.res.externalapi;

import com.green.sahwang.usedproduct.dto.response.GeneralUsedProductResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyerResDto {
    private Long purchaseId;

    private String buyerEmail;

    private String buyerName;

    private String buyerAddr;

    private String buyerPostcode;

    private String buyerPhone;

    private String payMethod;

    private int amount;

    private List<GeneralUsedProductResDto> usedProductResDtos;
}
