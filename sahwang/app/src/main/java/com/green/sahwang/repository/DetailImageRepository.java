package com.green.sahwang.repository;

import com.green.sahwang.entity.DetailImage;
import com.green.sahwang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailImageRepository extends JpaRepository<DetailImage, Long> {
    DetailImage findByProduct(Product product);
}
