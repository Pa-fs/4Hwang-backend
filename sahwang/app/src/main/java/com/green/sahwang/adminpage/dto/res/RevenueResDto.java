package com.green.sahwang.adminpage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RevenueResDto {
    private String saleDate;
    private int categoryTotalPrice;
    private String categoryName;
}
