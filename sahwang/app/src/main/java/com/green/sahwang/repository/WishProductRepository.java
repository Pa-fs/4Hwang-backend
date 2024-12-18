package com.green.sahwang.repository;

import com.green.sahwang.entity.WishProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WishProductRepository extends JpaRepository<WishProduct, Long> {

    @Query(value = """
            SELECT wp FROM WishProduct wp
            JOIN FETCH wp.member m
            JOIN FETCH wp.usedProduct up
            JOIN FETCH up.verifiedSale vs
            JOIN FETCH vs.pendingSale ps
            JOIN FETCH ps.product p
            JOIN FETCH ps.userSaleImages usi
            WHERE m.id = :memberId
            """,
            countQuery = """
            SELECT COUNT(wp.id)
            FROM WishProduct wp
            JOIN wp.member m
            JOIN wp.usedProduct up
            JOIN up.verifiedSale vs
            JOIN vs.pendingSale ps
            JOIN ps.product p
            JOIN ps.userSaleImages usi
            WHERE m.id = :memberId
            """)
    Page<WishProduct> findWishProductByMemberId(@Param("memberId") Long memberId, Pageable pageable);

}
