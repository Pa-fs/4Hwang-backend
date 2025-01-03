package com.green.sahwang.payment.repository;

import com.green.sahwang.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByMemberId(Long id);

    Optional<Payment> findByImpUid(String impUid);
}
