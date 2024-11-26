package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishRepository extends JpaRepository<Wish, Long> {
    List<Wish> findAllByProductInAndMember(List<Product> product, Member member);
    Wish findByProductAndMember(Product product, Member member);
    List<Wish> findAllByMemberAndIsChecked(Member member, Boolean isChecked);
}
