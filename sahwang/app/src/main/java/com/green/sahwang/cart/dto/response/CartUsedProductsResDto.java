package com.green.sahwang.cart.dto.response;

import com.green.sahwang.usedproduct.dto.response.GeneralUsedProductResDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartUsedProductsResDto {
    private GeneralUsedProductResDto generalUsedProductResDto;
    private int quantity;
}
