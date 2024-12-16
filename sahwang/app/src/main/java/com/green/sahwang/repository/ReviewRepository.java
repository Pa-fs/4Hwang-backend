package com.green.sahwang.repository;

import com.green.sahwang.adminpage.dto.res.ReviewManageResDto;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByPurchaseProductIn(List<PurchaseProduct> purchaseProducts);

    Page<Review> findAllByPurchaseProductIn(List<PurchaseProduct> purchaseProducts, Pageable pageable);

    @EntityGraph(attributePaths = {"member", "purchaseProduct"})
    Page<Review> findAllByMember(Member member, Pageable pageable);

    List<Review> findAllByMember(Member member);

    Page<Review> findAll(Pageable pageable);

    @Query("SELECT new com.green.sahwang.adminpage.dto.res.ReviewManageResDto( " +
            "r.image, pp.productName, p.size, p.dtype, " +
            "r.content, r.star, m.nickName, r.reviewCreationDate) " +
            "FROM Review r " +
            "JOIN r.purchaseProduct pp " +
            "JOIN pp.product p " +
            "JOIN r.member m")
    Page<ReviewManageResDto> findReviews(Pageable pageable);
}
