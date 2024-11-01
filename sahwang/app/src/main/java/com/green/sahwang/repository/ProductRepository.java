package com.green.sahwang.repository;

import com.green.sahwang.entity.Brand;
import com.green.sahwang.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByDtype(Pageable pageable, String dtype);

    List<Product> findProductsByBrandAndDtype(Brand brand, Pageable pageable, String dtype);

    @Query(value = "SELECT * FROM product p WHERE p.dtype= :dtype", nativeQuery = true)
    List<Product> findAllByDtype(@Param("dtype") String type);

    @Query("SELECT p FROM Product p ORDER BY FUNCTION('RAND')")
    List<Product> findRandomProducts(Pageable pageable);

    @Query("SELECT p FROM Product p\n" +
            "WHERE p.id IN (\n" +
            "    SELECT MIN(p2.id) FROM Product p2\n" +
            "    GROUP BY p2.dtype\n" +
            ")")
    List<Product> findBestProducts(Pageable pageable);

    List<Product> findAllByName(String productName);

    Product findByNameAndSize(String name, int size);

}
