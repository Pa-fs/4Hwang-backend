package com.green.sahwang.repository;

import com.green.sahwang.entity.Brand;
import com.green.sahwang.entity.Category;
import com.green.sahwang.entity.CategoryBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryBrandRepository extends JpaRepository<CategoryBrand, Long> {
    boolean existsByCategoryAndBrand(Category category, Brand brand);

    @Query("select cb.brand from CategoryBrand cb where cb.category.id = :categoryId")
    List<Brand> findBrandsByCategoryId(@Param("categoryId") Long categoryId);
}
