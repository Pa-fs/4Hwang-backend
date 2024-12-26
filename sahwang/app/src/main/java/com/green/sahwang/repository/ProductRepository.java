package com.green.sahwang.repository;

import com.green.sahwang.brand.entity.Brand;
import com.green.sahwang.dto.response.ProductWithSaleInfoDto;
import com.green.sahwang.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    Page<Product> findAllProductsByDtype(Pageable pageable, String dtype);

    List<Product> findProductsByBrandAndDtype(Brand brand, Pageable pageable, String dtype);

    @Query(value = "SELECT * FROM product p WHERE p.dtype= :dtype", nativeQuery = true)
    List<Product> findAllByDtype(@Param("dtype") String type);

    @Query("SELECT p FROM Product p ORDER BY FUNCTION('RAND')")
    List<Product> findRandomProducts(Pageable pageable);

    List<Product> findAllByName(String productName);

    List<Product> findAllByNameContaining(String search);

    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT(:keyword, '%') ORDER BY p.name ASC LIMIT 5")
    List<Product> findByKeyword(@Param("keyword") String keyword);

    List<Product> findAllByBrandId(Long brandId);

    Optional<Product> findByName(String productName);

    @Query(value = "SELECT * FROM product ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Product> findByRandom();


}
