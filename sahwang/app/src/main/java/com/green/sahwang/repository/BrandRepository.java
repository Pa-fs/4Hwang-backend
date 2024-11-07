package com.green.sahwang.repository;

import com.green.sahwang.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAllByNameContaining(String search);
}
