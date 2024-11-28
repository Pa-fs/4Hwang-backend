package com.green.sahwang.repository;

import com.green.sahwang.entity.DeliveryPurchase;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryPurchasesRepository extends JpaRepository<DeliveryPurchase, Long> {
    List<DeliveryPurchase> findAllByPurchaseIn(List<Purchase> purchasePage);
    DeliveryPurchase findByPurchase(Purchase purchase);
    DeliveryPurchase findByPurchaseProduct(PurchaseProduct purchaseProduct);
}
