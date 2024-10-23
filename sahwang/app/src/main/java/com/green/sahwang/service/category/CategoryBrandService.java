package com.green.sahwang.service.category;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.dto.response.CategoryBrandResDto;

import java.util.List;

public interface CategoryBrandService {

    List<ProductResDto> getProductsByCategory(Long categoryId, int pageNum, int size, String sortType);

    CategoryBrandResDto getBrandsAndProductsByCategory(Long categoryId, int pageNum, int size, String sortType);
}
