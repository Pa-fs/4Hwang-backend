package com.green.sahwang.repository;

import com.green.sahwang.entity.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long> {
    Optional<PurchaseProduct> findByProductIdAndPurchaseId(Long productId, Long purchaseId);
}
