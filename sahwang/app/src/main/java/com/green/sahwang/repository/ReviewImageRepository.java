package com.green.sahwang.repository;

import com.green.sahwang.adminpage.dto.ReviewManageDto;
import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.ReviewImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {
    ReviewImage findByReview(Review review);
    List<ReviewImage> findAllByReviewIn(List<Review> reviewList);
    @Query("SELECT new com.green.sahwang.adminpage.dto.ReviewManageDto( " +
            "r.id, ri.filename, pp.productName, vs.productSize, ps.categoryName, " +
            "r.content, r.star, m.nickName, r.reviewCreationDate, " +
            "COUNT(f.id) AS favoriteCount) " +
            "FROM ReviewImage ri " +
            "JOIN ri.review r " +
            "JOIN r.purchaseProduct pp " +
            "JOIN pp.usedProduct up " +
            "JOIN up.verifiedSale vs " +
            "JOIN vs.pendingSale ps " +
            "JOIN r.member m " +
            "LEFT JOIN Favorite f ON r.id = f.review.id " +
            "GROUP BY r.id, ri.filename, pp.productName, vs.productSize, ps.categoryName, " +
            "r.content, r.star, m.nickName, r.reviewCreationDate")
    Page<ReviewManageDto> findReviews(Pageable pageable);

    @Query("SELECT new com.green.sahwang.adminpage.dto.ReviewManageDto( " +
            "r.id, ri.filename, pp.productName, vs.productSize, ps.categoryName, " +
            "r.content, r.star, m.nickName, r.reviewCreationDate, " +
            "COUNT(f.id) AS favoriteCount) " +
            "FROM ReviewImage ri " +
            "JOIN ri.review r " +
            "JOIN r.purchaseProduct pp " +
            "JOIN pp.usedProduct up " +
            "JOIN up.verifiedSale vs " +
            "JOIN vs.pendingSale ps " +
            "JOIN r.member m " +
            "LEFT JOIN Favorite f ON r.id = f.review.id " +
            "WHERE " +
            "pp.productName LIKE CONCAT('%', :searchKeyword, '%') OR " +
            "ps.categoryName LIKE CONCAT('%', :searchKeyword, '%') OR " +
            "r.content LIKE CONCAT('%', :searchKeyword, '%') OR " +
            "m.nickName LIKE CONCAT('%', :searchKeyword, '%') " +
            "GROUP BY r.id, ri.filename, pp.productName, vs.productSize, ps.categoryName, " +
            "r.content, r.star, m.nickName, r.reviewCreationDate")
    Page<ReviewManageDto> findReviewsBySearch(@Param("searchKeyword") String searchKeyword, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM review_image
            WHERE review_id = :reviewId
            """,nativeQuery = true)
    void deleteByReviewId(@Param("reviewId") Long reviewId);

    @Query(value = """
            SELECT r.review_id, r.content, ri.filename, r.review_creation_date, r.star, m.member_id, pp.purchase_product_id, vs.product_name, vs.product_size
            FROM review_image ri
            INNER JOIN review r ON r.review_id = ri.review_id
            INNER JOIN member m ON m.member_id = r.member_id
            INNER JOIN purchase_product pp ON pp.purchase_product_id = r.purchase_product_id
            INNER JOIN used_product up ON up.used_product_id = pp.used_product_id
            INNER JOIN verified_sale vs ON vs.verified_sale_id = up.verified_sale_id
            WHERE m.member_id = :memberId
            """, nativeQuery = true)
    List<Object[]> findMyReviews(@Param("memberId") Long memberId);
}
