package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.WishCategory;
import com.green.sahwang.mypage.dto.WishListCategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishRepository extends JpaRepository<WishCategory, Long> {
    List<WishCategory> findAllByProductInAndMember(List<Product> product, Member member);
    WishCategory findByProductAndMember(Product product, Member member);
    List<WishCategory> findAllByMemberAndIsChecked(Member member, Boolean isChecked);
    Page<WishCategory> findAllByMemberAndIsChecked(Member member, Boolean isChecked, Pageable pageable);
    @Query("""
    SELECT new com.green.sahwang.mypage.dto.WishListCategoryDto (wc.isChecked, p.id, p.name, p.mainImage)
                FROM WishCategory wc
                JOIN wc.product p
                WHERE wc.isChecked = true AND wc.member = :member
""")
    Page<WishListCategoryDto> findWishes(@Param("member") Member member, Pageable pageable);
}
