package com.green.sahwang.service.category;

import com.green.sahwang.service.impl.category.CategoryBrandResponse;

public interface CategoryBrandService {

    CategoryBrandResponse getBrandsAndProductsByCategory(Long categoryId, int pageNum, int size, String sortType);
}
