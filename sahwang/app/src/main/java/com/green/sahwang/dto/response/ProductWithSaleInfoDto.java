package com.green.sahwang.dto.response;

import com.green.sahwang.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithSaleInfoDto {

    private Product product;
    private int minPrice;
    private int maxPrice;
    private int minSize;
    private int maxSize;
}
