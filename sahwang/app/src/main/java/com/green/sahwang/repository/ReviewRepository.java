package com.green.sahwang.repository;

import com.green.sahwang.adminpage.dto.DashReviewListDto;
import com.green.sahwang.adminpage.dto.ReviewManageDto;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByPurchaseProductIn(List<PurchaseProduct> purchaseProducts);

    Page<Review> findAllByPurchaseProductIn(List<PurchaseProduct> purchaseProducts, Pageable pageable);

    @EntityGraph(attributePaths = {"member", "purchaseProduct"})
    Page<Review> findAllByMember(Member member, Pageable pageable);

    List<Review> findAllByMember(Member member);

    Page<Review> findAll(Pageable pageable);

    @Query(value = """
            SELECT r.review_id, r.content, r.review_creation_date, vs.brand_name, vs.category_name, vs.product_name, vs.product_size, m.nick_name
            FROM review r
            INNER JOIN member m ON m.member_id = r.member_id
            INNER JOIN purchase_product pp ON pp.purchase_product_id = r.purchase_product_id
            INNER JOIN used_product up ON up.used_product_id = pp.used_product_id
            INNER JOIN verified_sale vs ON vs.verified_sale_id = up.verified_sale_id
            WHERE DATE(r.review_creation_date) = CURRENT_DATE
            AND vs.rejected_sale_id IS NULL;
            """,nativeQuery = true)
    List<Object[]> findDashReviews();

    @Query(value = """
            SELECT COUNT(*)
            FROM review r
            INNER JOIN member m ON m.member_id = r.member_id
            INNER JOIN purchase_product pp ON pp.purchase_product_id = r.purchase_product_id
            INNER JOIN used_product up ON up.used_product_id = pp.used_product_id
            INNER JOIN verified_sale vs ON vs.verified_sale_id = up.verified_sale_id
            WHERE DATE(r.review_creation_date) = CURRENT_DATE
            AND vs.rejected_sale_id IS NULL;
            """,nativeQuery = true)
    int getDashReviews();

}
