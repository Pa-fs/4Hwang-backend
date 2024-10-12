package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByMemberId(Long id);
}
