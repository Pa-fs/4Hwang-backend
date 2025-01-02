package com.green.sahwang.adminpage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RevenueResWithTotalPriceDto {
    private List<RevenueResDto> revenueResDtos;
    private int totalPrice;
}
