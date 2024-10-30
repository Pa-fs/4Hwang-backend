package com.green.sahwang.service;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.entity.enumtype.ProductTypeGroup;

import java.util.List;

public interface ProductTypeService {
    List<ProductResDto> getProductResDtoByGroup(ProductTypeGroup productTypeGroup);
}
