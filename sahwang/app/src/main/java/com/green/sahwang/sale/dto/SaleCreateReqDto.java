package com.green.sahwang.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleCreateReqDto {

    private String productName;
    private int quantity;
    private int size;
    private String dtype;
    private int expectedSellingPrice;
    private String brandName;
    private boolean usedOrNot;
}
