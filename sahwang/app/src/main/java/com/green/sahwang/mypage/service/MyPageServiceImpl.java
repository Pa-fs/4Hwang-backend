package com.green.sahwang.mypage.service;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.mypage.dto.OrderProgressResDto;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.PurchasePaymentRepository;
import com.green.sahwang.repository.PurchaseProductRepository;
import com.green.sahwang.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{

    private final MemberRepository memberRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final PurchasePaymentRepository purchasePaymentRepository;

    @Transactional
    public OrderProgressResDto getOrderProgress(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Purchase purchase = purchaseRepository.findTopByMemberAndStatusOrderByPurchaseDateDesc(member, true);

        OrderProgressResDto orderProgressResDto = new OrderProgressResDto();
        orderProgressResDto.setStatus(purchase.getPurchaseStatus());

        return orderProgressResDto;
    }

}
