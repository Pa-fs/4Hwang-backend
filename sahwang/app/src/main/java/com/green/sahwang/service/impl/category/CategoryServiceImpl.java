package com.green.sahwang.service.impl.category;

import com.green.sahwang.brand.entity.Brand;
import com.green.sahwang.entity.Category;
import com.green.sahwang.entity.CategoryBrand;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.CategoryDomainException;
import com.green.sahwang.brand.repository.BrandRepository;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.repository.CategoryBrandRepository;
import com.green.sahwang.repository.CategoryRepository;
import com.green.sahwang.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final CategoryBrandRepository categoryBrandRepository;

    @Transactional
    public Category addBrandToCategory(Long categoryId, Long brandId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new BizException(ErrorCode.NO_CATEGORY));

        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new BizException(ErrorCode.NO_BRAND));

        boolean exists = categoryBrandRepository.existsByCategoryAndBrand(category, brand);
        if (!exists) {
            CategoryBrand categoryBrand = CategoryBrand.builder()
                    .category(category)
                    .brand(brand)
                    .createdDate(LocalDateTime.now())
                    .build();

            categoryBrandRepository.save(categoryBrand);
        }
        return category;
    }
}
