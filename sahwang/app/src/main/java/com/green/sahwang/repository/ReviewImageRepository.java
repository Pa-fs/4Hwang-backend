package com.green.sahwang.repository;

import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.ReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {
    ReviewImage findByReview(Review review);
    List<ReviewImage> findAllByReviewIn(List<Review> reviewList);
}
