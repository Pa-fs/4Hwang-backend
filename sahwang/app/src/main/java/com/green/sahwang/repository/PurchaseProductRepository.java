package com.green.sahwang.repository;

import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long> {
    Optional<PurchaseProduct> findByProductIdAndPurchaseId(Long productId, Long purchaseId);

    List<PurchaseProduct> findByProductIdAndPurchaseIn(Long productId, List<Purchase> purchases);

    List<PurchaseProduct> findAllByPurchase(Purchase purchase);

    List<PurchaseProduct> findAllByProductId(Long productId);

    List<PurchaseProduct> findAllByProduct(Product product);

    List<PurchaseProduct> findAllByPurchaseIn(List<Purchase> purchasePage);

    Page<PurchaseProduct> findAllByPurchaseIn(List<Purchase> purchaseList, Pageable pageable);
}
