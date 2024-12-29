package com.green.sahwang.repository;

import com.green.sahwang.entity.SalePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SalePaymentRepository extends JpaRepository<SalePayment, Long> {
//    Optional<SalePayment> findBySaleProduct(SaleProduct saleProduct);

    @Query("""
        SELECT sp
        FROM SalePayment sp
        WHERE sp.createdDate BETWEEN :startDate AND :endDate
        ORDER BY sp.createdDate DESC
    """)
    List<SalePayment> findRevenue(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
