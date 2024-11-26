package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

    List<Purchase> findByPurchaseStatus(PurchaseStatus purchaseStatus);

    Purchase findTopByMemberAndStatusOrderByPurchaseDateDesc(Member member, Boolean status);

}
