package com.green.sahwang.usedproduct.repository;

import com.green.sahwang.detail.dto.DetailProductInfoDto;
import com.green.sahwang.usedproduct.dto.VerifiedAndUserSaleImageResDto;
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

    @Query(value = """
            SELECT vsi.file_desc, vsi.filename, vsi.`path`, 'Verified'
            FROM verified_sale_image vsi
            INNER JOIN verified_sale vs ON vsi.verified_sale_id = vs.verified_sale_id
            INNER JOIN used_product up ON up.verified_sale_id = vs.verified_sale_id
            WHERE up.used_product_id = :usedProductId
            AND vs.rejected_sale_id IS NULL
            UNION ALL
            SELECT usi.file_desc, usi.filename, usi.`path`, 'User'
            FROM user_sale_image usi
            INNER JOIN pending_sale ps ON usi.pending_sale_id = ps.pending_sale_id
            INNER JOIN verified_sale vs ON ps.pending_sale_id = vs.pending_sale_id
            INNER JOIN used_product up ON vs.verified_sale_id = up.verified_sale_id
            WHERE up.used_product_id = :usedProductId
            AND vs.rejected_sale_id IS NULL
            """, nativeQuery = true)
    List<Object[]> findByUsedProductId(@Param("usedProductId") Long usedProductId);

    @Query(value = """
            SELECT p.product_id, up.used_product_id, ppay.purchase_payment_id, ppay.created_date, ppay.trade_price, ppay.trade_size
            FROM product p
            INNER JOIN pending_sale ps ON p.product_id = ps.product_id
            INNER JOIN verified_sale vs ON ps.pending_sale_id = vs.pending_sale_id
            INNER JOIN used_product up ON up.verified_sale_id = vs.verified_sale_id
            INNER JOIN purchase_product pp ON pp.used_product_id = up.used_product_id
            INNER JOIN purchase_payment ppay ON ppay.purchase_product_id = pp.purchase_product_id
            WHERE p.product_id = (SELECT p.product_id
            FROM used_product up
            INNER JOIN verified_sale vs ON up.verified_sale_id = vs.verified_sale_id
            INNER JOIN pending_sale ps ON vs.pending_sale_id = ps.pending_sale_id
            INNER JOIN product p ON ps.product_id = p.product_id
            WHERE up.used_product_id = :usedProductId
            AND vs.rejected_sale_id IS NULL)
            AND vs.rejected_sale_id IS NULL
            """, nativeQuery = true)
    List<Object[]> findReviewInfo(@Param("usedProductId") Long usedProductId);

    @Query(value = """
            SELECT p.product_id, up.used_product_id, ppay.purchase_payment_id, ppay.created_date, ppay.trade_price, ppay.trade_size
            FROM product p
            INNER JOIN pending_sale ps ON p.product_id = ps.product_id
            INNER JOIN verified_sale vs ON ps.pending_sale_id = vs.pending_sale_id
            INNER JOIN used_product up ON up.verified_sale_id = vs.verified_sale_id
            INNER JOIN purchase_product pp ON pp.used_product_id = up.used_product_id
            INNER JOIN purchase_payment ppay ON ppay.purchase_product_id = pp.purchase_product_id
            WHERE p.product_id = (SELECT p.product_id
            FROM used_product up
            INNER JOIN verified_sale vs ON up.verified_sale_id = vs.verified_sale_id
            INNER JOIN pending_sale ps ON vs.pending_sale_id = ps.pending_sale_id
            INNER JOIN product p ON ps.product_id = p.product_id
            WHERE up.used_product_id = :usedProductId
            AND vs.rejected_sale_id IS NULL)
            AND vs.rejected_sale_id IS NULL
            AND ppay.created_date >= DATE_ADD(NOW(), INTERVAL -1 MONTH)
            """, nativeQuery = true)
    List<Object[]> findReviewInfoOneMonth(@Param("usedProductId") Long usedProductId);

    @Query(value = """
            SELECT p.product_id, up.used_product_id, ppay.purchase_payment_id, ppay.created_date, ppay.trade_price, ppay.trade_size
            FROM product p
            INNER JOIN pending_sale ps ON p.product_id = ps.product_id
            INNER JOIN verified_sale vs ON ps.pending_sale_id = vs.pending_sale_id
            INNER JOIN used_product up ON up.verified_sale_id = vs.verified_sale_id
            INNER JOIN purchase_product pp ON pp.used_product_id = up.used_product_id
            INNER JOIN purchase_payment ppay ON ppay.purchase_product_id = pp.purchase_product_id
            WHERE p.product_id = (SELECT p.product_id
            FROM used_product up
            INNER JOIN verified_sale vs ON up.verified_sale_id = vs.verified_sale_id
            INNER JOIN pending_sale ps ON vs.pending_sale_id = ps.pending_sale_id
            INNER JOIN product p ON ps.product_id = p.product_id
            WHERE up.used_product_id = :usedProductId
            AND vs.rejected_sale_id IS NULL)
            AND vs.rejected_sale_id IS NULL
            AND ppay.created_date >= DATE_ADD(NOW(), INTERVAL -6 MONTH)
            """, nativeQuery = true)
    List<Object[]> findReviewInfoSixMonth(@Param("usedProductId") Long usedProductId);
}
