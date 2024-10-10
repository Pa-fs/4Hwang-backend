package com.green.sahwang.entity;

import com.green.sahwang.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class PurchasePaymentTest {

    @Autowired
    PurchasePaymentRepository purchasePaymentRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PurchaseProductRepository purchaseProductRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @BeforeEach
    void setUp(){
        Member member = new Member();
        member.setName("인간");
        Member savedMember = memberRepository.save(member);

        log.info("{}: member_id", savedMember.getId());

        Payment payment = new Payment();
        payment.setMember(memberRepository.findAll().get(0));
        paymentRepository.save(payment);

        Purchase purchase = new Purchase();
        purchase.setMember(member);
        purchaseRepository.save(purchase);

        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setPurchase(purchaseRepository.findAll().get(0));
        purchaseProductRepository.save(purchaseProduct);
    }

    @Test
    void paymentRepositoryTest(){
        Payment payment = paymentRepository.findByMemberId(memberRepository.findAll().get(0).getId())
                .orElseThrow(() -> new RuntimeException("no Payment"));

        assertThat(payment).isNotNull();
    }

    @Test
    @DisplayName("결제_결제구매내역 매핑 테스트")
    void testPaymentPurchasePayment(){
        Payment payment = paymentRepository.findByMemberId(memberRepository.findAll().get(0).getId())
                .orElseThrow(()-> new RuntimeException("no payment"));

        PurchasePayment purchasePayment = new PurchasePayment();
        purchasePayment.setPayment(payment);
        purchasePaymentRepository.save(purchasePayment);

        PurchasePayment findPurchasePayment = purchasePaymentRepository.findById(purchasePayment.getId())
                .orElseThrow(()-> new RuntimeException("no purchasePayment"));

        assertThat(findPurchasePayment).isNotNull();
        assertThat(findPurchasePayment.getPayment().getId()).isEqualTo(payment.getId());
    }

    @Test
    @DisplayName("주문내역_결제구매내역 매핑 테스트")
    void testPurchaseProductPurchasePayment(){
        PurchaseProduct purchaseProduct = purchaseProductRepository.findAll().get(0);
        PurchasePayment purchasePayment = new PurchasePayment();
        purchasePayment.setPurchaseProduct(purchaseProduct);
        purchasePaymentRepository.save(purchasePayment);

        PurchasePayment findPurchasePayment = purchasePaymentRepository.findById(purchasePayment.getId())
                .orElseThrow(() -> new RuntimeException("no purchasePayment"));

        assertThat(findPurchasePayment).isNotNull();
        assertThat(findPurchasePayment.getPurchaseProduct().getId()).isEqualTo(purchaseProduct.getId());
    }

}