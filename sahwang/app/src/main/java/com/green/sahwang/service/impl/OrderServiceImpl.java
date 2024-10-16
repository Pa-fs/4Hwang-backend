package com.green.sahwang.service.impl;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final PurchaseRepository purchaseRepository;

    @Override
    @Transactional
    public void processCancelOrder(Long orderId) {
        Purchase findPurchase = purchaseRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("주문(구매)번호가 존재하지 않습니다"));

        Member member = findPurchase.getMember();

        log.info("주문 취소한 회원ID: {}", member.getId());
    }
}
