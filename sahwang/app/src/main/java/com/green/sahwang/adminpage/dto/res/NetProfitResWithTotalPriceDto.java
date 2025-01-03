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
public class NetProfitResWithTotalPriceDto {
    private List<NetProfitResDto> netProfitResDtos;
    private int totalPrice;
}
