package com.green.sahwang.repository;

import com.green.sahwang.entity.ProductType;
import com.green.sahwang.entity.enumtype.ProductTypeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    List<ProductType> findAllByProductTypeGroup(ProductTypeGroup productTypeGroup);

}
