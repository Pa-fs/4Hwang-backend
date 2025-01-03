package com.green.sahwang.adminpage.dto.res;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetProfitResDto {
//    private Long usedProductId;
//    private int netProfit; // 매출수익 (5% 제외금액)
//    private String saleDate;
    private String saleDate;
    private int categoryNetProfit; // 매출수익 (5% 제외금액)
    private String categoryName;
}