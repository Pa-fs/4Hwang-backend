package com.green.sahwang.repository;

import com.green.sahwang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
    @Query(value = "SELECT * FROM product p WHERE p.dtype= :dtype", nativeQuery = true)
    List<Product> findAllByDtype(@Param("dtype") String type);
}
