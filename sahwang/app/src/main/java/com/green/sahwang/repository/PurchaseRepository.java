package com.green.sahwang.repository;

import com.green.sahwang.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
