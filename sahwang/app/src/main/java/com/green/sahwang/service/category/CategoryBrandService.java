package com.green.sahwang.service.category;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.service.impl.category.CategoryBrandResponse;

import java.util.List;

public interface CategoryBrandService {

    List<ProductResDto> getProductsByCategory(Long categoryId, int pageNum, int size, String sortType);

    CategoryBrandResponse getBrandsAndProductsByCategory(Long categoryId, int pageNum, int size, String sortType);
}
