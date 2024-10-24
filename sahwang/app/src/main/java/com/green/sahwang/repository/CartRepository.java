package com.green.sahwang.repository;

import com.green.sahwang.entity.Cart;
import com.green.sahwang.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByMember(Member member);
}
