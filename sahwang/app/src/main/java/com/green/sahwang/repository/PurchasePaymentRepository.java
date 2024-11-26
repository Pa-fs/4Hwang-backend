package com.green.sahwang.repository;

import com.green.sahwang.entity.Payment;
import com.green.sahwang.entity.PurchasePayment;
import com.green.sahwang.entity.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PurchasePaymentRepository extends JpaRepository<PurchasePayment, Long> {
    List<PurchasePayment> findAllByPurchaseProductIn(List<PurchaseProduct> purchaseProductList);

    List<PurchasePayment> findAllByPayment(Payment payment);

    List<PurchasePayment> findAllByPurchaseProductInAndCreatedDateAfter(List<PurchaseProduct> purchaseProductList, LocalDateTime month);
}
