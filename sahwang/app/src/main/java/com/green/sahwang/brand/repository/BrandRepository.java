package com.green.sahwang.brand.repository;

import com.green.sahwang.brand.entity.Brand;
import com.green.sahwang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAllByNameContaining(String search);

    @Query("SELECT b FROM Brand b WHERE b.name LIKE CONCAT(:keyword, '%') ORDER BY b.name ASC LIMIT 5")
    List<Brand> findByKeyword(@Param("keyword") String keyword);
}
