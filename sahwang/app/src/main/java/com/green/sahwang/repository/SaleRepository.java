package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    Sale findTopByMemberOrderBySaleStartDateDesc(Member member);
}
