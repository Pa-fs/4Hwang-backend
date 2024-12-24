package com.green.sahwang.repository;

import com.green.sahwang.entity.SalePayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalePaymentRepository extends JpaRepository<SalePayment, Long> {
//    Optional<SalePayment> findBySaleProduct(SaleProduct saleProduct);
}
