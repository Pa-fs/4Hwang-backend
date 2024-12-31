package com.green.sahwang.repository;

import com.green.sahwang.entity.Favorite;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findAllByReviewIn(List<Review> reviewList);
    Page<Favorite> findAllByReviewIn(List<Review> reviewList, Pageable pageable);
//    Favorite findByMemberAndReview(Member member, Review review);
    Optional<Favorite> findByMemberAndReview(Member member, Review review);
    List<Favorite> findAllByReview(Review review);
    List<Favorite> findAllByReviewId(Long reviewId);
    List<Favorite> deleteAllByReview(Review review);

    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM favorite
            WHERE review_id = :reviewId
            """,nativeQuery = true)
    void deleteByReviewId(@Param("reviewId") Long reviewId);
}
