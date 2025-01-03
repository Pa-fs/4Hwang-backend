package com.green.sahwang.repository;

import com.green.sahwang.adminpage.dto.res.OrderManageResDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.mypage.dto.res.OrderListResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long> {
    Optional<PurchaseProduct> findByUsedProductIdAndPurchaseId(Long usedProductId, Long purchaseId);


    @Query("""
            select pp from PurchaseProduct pp
            join fetch pp.purchase pur
            join fetch pp.usedProduct up
            join fetch up.verifiedSale vs
            join fetch vs.pendingSale ps
            join fetch ps.product p
            where p.id = :productId
            and pur.id in (:purchases)
            """)
    List<PurchaseProduct> findByProductIdAndPurchaseIn(@Param("productId") Long productId, @Param("purchases") List<Long> purchases);

    List<PurchaseProduct> findAllByPurchase(Purchase purchase);

    List<PurchaseProduct> findAllByUsedProductId(Long usedProductId);

    @Query("""
            select pp from PurchaseProduct pp
            join fetch pp.usedProduct up
            join fetch up.verifiedSale vs
            join fetch vs.pendingSale ps
            join fetch ps.product p
            where p.id = :product
            """)
    List<PurchaseProduct> findAllByProduct(@Param("product") Product product);

    List<PurchaseProduct> findAllByPurchaseIn(List<Purchase> purchasePage);

    Page<PurchaseProduct> findAllByPurchaseIn(List<Purchase> purchaseList, Pageable pageable);

    @Query("""
            SELECT new com.green.sahwang.mypage.dto.res.OrderListResDto(
                    pp.id,
                    pr.name,
                    vs.brandName,
                    vs.productName,
                    vs.productSize,
                    ps.exceptedSellingPrice,
                    pp.purchaseCreationDate,
                    p.purchaseStatus,
                    MIN(usi.filename)
                )
                FROM PurchaseProduct pp
                JOIN pp.purchase p
                JOIN pp.usedProduct up
                JOIN up.verifiedSale vs
                JOIN vs.pendingSale ps
                JOIN ps.userSaleImages usi
                JOIN ps.product pr
                WHERE vs.rejectionReason IS NULL
                AND p.purchaseStatus IN ('PAID', 'SHIP_READY', 'SHIPPING', 'SHIPPED', 'COMPLETED', 'CANCEL', 'CANCELLED', 'REVIEWED')
                AND p.member.id = :memberId
                GROUP BY pp.id, pr.name, vs.brandName, vs.productName, vs.productSize, ps.exceptedSellingPrice, pp.purchaseCreationDate, p.purchaseStatus
                ORDER BY pp.purchaseCreationDate DESC
            """)
    Page<OrderListResDto> findPurchaseProductsByMemberId(@Param("memberId") Long memberId, Pageable pageable);

    @Query("""
            SELECT new com.green.sahwang.adminpage.dto.res.OrderManageResDto(
                    pp.id,
                    pr.name,
                    vs.brandName,
                    vs.productName,
                    vs.productSize,
                    vs.categoryName,
                    ps.exceptedSellingPrice,
                    pp.purchaseCreationDate,
                    p.purchaseStatus,
                    m.nickName,
                    m.name,
                    dp.deliveredDate,
                    dp.status,
                    MIN(usi.filename)
                )
                FROM PurchaseProduct pp
                JOIN pp.purchase p
                JOIN pp.usedProduct up
                JOIN up.verifiedSale vs
                JOIN vs.pendingSale ps
                JOIN ps.userSaleImages usi
                JOIN ps.product pr
                JOIN p.member m
                LEFT JOIN DeliveryPurchase dp ON dp.purchaseProduct.id = pp.id
                WHERE vs.rejectionReason IS NULL
                GROUP BY pp.id, pr.name, vs.brandName, vs.productName, vs.productSize, vs.categoryName,
                         ps.exceptedSellingPrice, pp.purchaseCreationDate, p.purchaseStatus,
                         m.nickName, m.name, dp.deliveredDate, dp.status
                ORDER BY pp.purchaseCreationDate DESC
            """)
    Page<OrderManageResDto> findOrders(Pageable pageable);

    @Query(value = """
            SELECT pp.purchase_product_id, pp.purchase_creation_date, pro.`name`, vs.product_name, ps.excepted_selling_price, m.nick_name
            FROM purchase_product pp
            INNER JOIN purchase p ON p.purchase_id = pp.purchase_id
            INNER JOIN member m ON m.member_id = p.member_id
            INNER JOIN used_product up ON up.used_product_id = pp.used_product_id
            INNER JOIN verified_sale vs ON vs.verified_sale_id = up.verified_sale_id
            INNER JOIN pending_sale ps ON ps.pending_sale_id = vs.pending_sale_id
            INNER JOIN product pro ON pro.product_id = ps.product_id
            WHERE DATE(pp.purchase_creation_date) = CURRENT_DATE
            AND vs.rejected_sale_id IS NULL;
            """, nativeQuery = true)
    List<Object[]> findDashOrders();

    @Query(value = """
            SELECT COUNT(*)
            FROM purchase_product pp
            INNER JOIN purchase p ON p.purchase_id = pp.purchase_id
            INNER JOIN member m ON m.member_id = p.member_id
            INNER JOIN used_product up ON up.used_product_id = pp.used_product_id
            INNER JOIN verified_sale vs ON vs.verified_sale_id = up.verified_sale_id
            INNER JOIN pending_sale ps ON ps.pending_sale_id = vs.pending_sale_id
            INNER JOIN product pro ON pro.product_id = ps.product_id
            WHERE DATE(pp.purchase_creation_date) = CURRENT_DATE
            AND vs.rejected_sale_id IS NULL;
            """,nativeQuery = true)
    int getDashOrderCount();
}
