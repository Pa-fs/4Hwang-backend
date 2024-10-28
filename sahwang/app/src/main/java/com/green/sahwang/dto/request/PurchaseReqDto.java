package com.green.sahwang.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseReqDto {

    @NotEmpty
    private List<PurchaseProductReqDto> purchaseProductDtos;

    // 결제 예정 금액
    @NotNull
    @Min(0)
    private Long totalPrice;

    @Data
    public static class PurchaseProductReqDto {
        @NotNull
        private Long productId;

        @NotNull
        @Min(1)
        private Integer quantity;
    }
}
