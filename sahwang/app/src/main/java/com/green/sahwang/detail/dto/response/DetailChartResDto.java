package com.green.sahwang.detail.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailChartResDto {

    private Long productId;

    private Long usedProductId;

    private Long purchasePaymentId;

    private LocalDateTime createdDate;

    private int tradePrice;

    private int tradeSize;

}
