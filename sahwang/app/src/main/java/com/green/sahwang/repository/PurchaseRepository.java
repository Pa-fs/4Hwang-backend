package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

    List<Purchase> findAllByPurchaseStatus(PurchaseStatus purchaseStatus);

    Optional<Purchase> findTopByMemberAndStatusOrderByPurchaseDateDesc(Member member, Boolean status);

    List<Purchase> findAllByMember(Member member);

    Page<Purchase> findAllByMember(Member member, Pageable pageable);

    List<Purchase> findByPurchaseStatus(PurchaseStatus purchaseStatus);

    List<Purchase> findAllByMemberAndPurchaseStatus(Member member, PurchaseStatus purchaseStatus);

    @Query(value = """
            SELECT COUNT(*)
            FROM purchase p
            INNER JOIN member m ON m.member_id = p.member_id
            INNER JOIN purchase_product pp ON pp.purchase_id = p.purchase_id
            INNER JOIN used_product up ON up.used_product_id = pp.used_product_id
            INNER JOIN verified_sale vs ON vs.verified_sale_id = up.verified_sale_id
            INNER JOIN pending_sale ps ON ps.pending_sale_id = vs.pending_sale_id
            WHERE vs.rejected_sale_id IS NULL
            AND m.member_id = :memberId
            """, nativeQuery = true)
    int purchaseListCountByMemberId(Long memberId);
}
