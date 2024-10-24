package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

//    Optional<Member> findByEmail(String email);
    Member findByEmail(String email);
}
