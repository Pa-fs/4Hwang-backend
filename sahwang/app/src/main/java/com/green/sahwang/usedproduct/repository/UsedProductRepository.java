package com.green.sahwang.usedproduct.repository;

import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.entity.enumtype.UsedProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsedProductRepository extends JpaRepository<UsedProduct, Long> {

    @Query(value = """
            select up from UsedProduct up
            join fetch up.verifiedSale vs
            join fetch vs.pendingSale ps
            join fetch ps.member m
            join fetch ps.product p
            where p.id = :productId
            and up.usedProductType = :usedProductType
            """,
            countQuery = """
            select count(up.id)
            from UsedProduct up
            join up.verifiedSale vs
            join vs.pendingSale ps
            join ps.member m
            join ps.product p
            where p.id = :productId
            and up.usedProductType = :usedProductType
            """)
    Page<UsedProduct> findUsedProductsByProductId(@Param("productId") Long productId, @Param("usedProductType") UsedProductType usedProductType, Pageable pageable);


}