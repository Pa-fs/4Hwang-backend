package com.green.sahwang.repository;

import com.green.sahwang.adminpage.dto.ReviewManageDto;
import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.ReviewImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
}
