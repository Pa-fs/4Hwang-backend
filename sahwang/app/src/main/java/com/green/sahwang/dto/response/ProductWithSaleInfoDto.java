package com.green.sahwang.dto.response;

import com.green.sahwang.entity.Product;
import com.green.sahwang.verifiedsale.entity.enumtype.GradeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithSaleInfoDto {

    private Product product;
    private int minPrice;
    private int maxPrice;
    private int minSize;
    private int maxSize;
    private String gradeTypes;
    private int rankNumber;
}
