package com.green.sahwang.mypage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleListWithTotalCountResDto {

    private List<SaleListResDto> saleListResDtos;
    private int totalCount;
}
