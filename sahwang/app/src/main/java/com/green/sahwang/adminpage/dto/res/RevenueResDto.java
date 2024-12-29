package com.green.sahwang.adminpage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RevenueResDto {
    private Long usedProductId;
    private int totalPrice; // 총 판매금액
    private int revenue; // 매출수익 (5% 제외금액)
    private String saleDate;
}
