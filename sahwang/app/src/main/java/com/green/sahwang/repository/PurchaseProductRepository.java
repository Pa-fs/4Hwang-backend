package com.green.sahwang.repository;

import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
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
    List<PurchaseProduct> findByProductIdAndPurchaseIn(@Param("productId") Long productId, @Param("purchases") List<Purchase> purchases);

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
}
