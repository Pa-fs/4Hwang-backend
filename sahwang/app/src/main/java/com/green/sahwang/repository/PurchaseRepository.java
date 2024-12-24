package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

    List<Purchase> findAllByPurchaseStatus(PurchaseStatus purchaseStatus);

    Optional<Purchase> findTopByMemberAndStatusOrderByPurchaseDateDesc(Member member, Boolean status);

    List<Purchase> findAllByMember(Member member);

    Page<Purchase> findAllByMember(Member member, Pageable pageable);

    List<Purchase> findByPurchaseStatus(PurchaseStatus purchaseStatus);

    List<Purchase> findAllByMemberAndPurchaseStatus(Member member, PurchaseStatus purchaseStatus);
}
