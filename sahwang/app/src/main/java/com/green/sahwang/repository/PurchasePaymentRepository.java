package com.green.sahwang.repository;

import com.green.sahwang.entity.PurchasePayment;
import com.green.sahwang.entity.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchasePaymentRepository extends JpaRepository<PurchasePayment, Long> {

    Optional<PurchaseProduct> findByPurchaseProduct(PurchaseProduct purchaseProduct);
}
