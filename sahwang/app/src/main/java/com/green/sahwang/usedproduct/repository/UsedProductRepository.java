package com.green.sahwang.usedproduct.repository;

import com.green.sahwang.detail.dto.DetailProductInfoDto;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.entity.enumtype.UsedProductType;
import com.green.sahwang.verifiedsale.entity.VerifiedSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsedProductRepository extends JpaRepository<UsedProduct, Long> {

    @Query(value = """
            select up from UsedProduct up
            join fetch up.verifiedSale vs
            join fetch vs.pendingSale ps
            join fetch ps.member m
            join fetch ps.product p
            where p.id = :productId
            and up.usedProductType = :usedProductType
            and vs.rejectionReason is null
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
            and vs.rejectionReason is null
            """)
    Page<UsedProduct> findUsedProductsByProductId(@Param("productId") Long productId, @Param("usedProductType") UsedProductType usedProductType, Pageable pageable);

    @Query("SELECT new com.green.sahwang.detail.dto.DetailProductInfoDto( " +
            "up.id, p.id, ps.brandName, vs.productName, " +
            "p.size, vs.productSize, vs.verifiedSellingPrice, sg.gradeType) " +
            "FROM UsedProduct up " +
            "JOIN up.verifiedSale vs " +
            "JOIN vs.saleGrade sg " +
            "JOIN vs.pendingSale ps " +
            "JOIN ps.product p " +
            "WHERE up.id = :usedProductId")
    DetailProductInfoDto findUsedProductInfo(@Param("usedProductId") Long usedProductId);

    List<UsedProduct> findAllByVerifiedSaleIn(List<VerifiedSale> verifiedSaleList);
}
