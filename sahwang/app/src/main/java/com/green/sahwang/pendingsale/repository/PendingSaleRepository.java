package com.green.sahwang.pendingsale.repository;

import com.green.sahwang.entity.Product;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import com.green.sahwang.mypage.dto.res.SaleListResDto;
import com.green.sahwang.pendingsale.entity.PendingSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PendingSaleRepository extends JpaRepository<PendingSale, Long> {
    Page<PendingSale> findAllByInspectionStatus(Pageable pageable, InspectionStatus status);
    List<PendingSale> findAllByProduct(Product product);

    @Query(value = """
            SELECT ps.inspectionStatus as saleStatus
            FROM PendingSale ps
            JOIN ps.member m
            WHERE m.id = :memberId
            ORDER BY ps.createdDate DESC
            """,
    countQuery = """
            SELECT count(ps.inspectionStatus) as saleStatus
            FROM PendingSale ps
            JOIN ps.member m
            WHERE m.id = :memberId
            ORDER BY ps.createdDate DESC
            """)
    Page<InspectionStatus> findSaleStatusByMemberId(@Param("memberId") Long memberId, Pageable pageable);

    @Query(value = """
            SELECT
            ps.category_name userCategory,
            ps.brand_name userBrand,
            ps.inspection_status saleStatus,
            ps.excepted_selling_price userPrice,
            ps.product_size userSize,
            ps.used_or_not userUsedOrNot,
            vs.product_size verifiedSize,
            vs.verified_selling_price verifiedPrice,
            vs.used_or_not verifiedUsedOrNot,
            up.used_product_type usedProductType
            FROM member m
            INNER JOIN pending_sale ps ON ps.member_id = m.member_id
            INNER JOIN verified_sale vs ON ps.pending_sale_id = vs.pending_sale_id
            INNER JOIN used_product up ON vs.verified_sale_id = up.used_product_id
            WHERE m.member_id = :memberId
            AND ps.inspection_status = 'ACCEPTED'
            ORDER BY ps.created_date DESC
            """, nativeQuery = true)
    Page<SaleListResDto> findAllVerifiedSaleList(@Param("memberId") Long memberId, Pageable pageable);

    Long countByInspectionStatus(InspectionStatus inspectionStatus);
}
