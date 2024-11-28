package com.green.sahwang.repository;

import com.green.sahwang.entity.Sale;
import com.green.sahwang.entity.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {
    List<SaleProduct> findAllBySale(Sale sale);
}
