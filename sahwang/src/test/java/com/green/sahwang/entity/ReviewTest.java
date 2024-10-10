package com.green.sahwang.entity;

import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.PurchaseProductRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReviewTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PurchaseProductRepository purchaseProductRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @BeforeEach
    void setUp(){
        Member member = new Member();
        member.setName("김씨");
        memberRepository.save(member);

        Purchase purchase = new Purchase();
        purchase.setMember(memberRepository.findAll().get(0));
        purchaseRepository.save(purchase);

        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setPurchase(purchaseRepository.findAll().get(0));
        purchaseProductRepository.save(purchaseProduct);
    }

    @Test
    @DisplayName("리뷰_멤버 매핑 테스트")
    void testReviewMember(){
        Member member = memberRepository.findAll().get(0);
        Review review = new Review();
        review.setMember(member);
        reviewRepository.save(review);

        Review findReview = reviewRepository.findById(review.getId())
                .orElseThrow(() -> new RuntimeException("no review"));

        assertThat(findReview).isNotNull();
        assertThat(findReview.getMember().getId()).isEqualTo(member.getId());
    }

    @Test
    @DisplayName("리뷰_주문내역 매핑 테스트")
    void testReviewPurchaseProduct(){
        PurchaseProduct purchaseProduct = purchaseProductRepository.findAll().get(0);
        Review review = new Review();
        review.setPurchaseProduct(purchaseProduct);
        reviewRepository.save(review);

        Review findReview = reviewRepository.findById(review.getId())
                .orElseThrow(() -> new RuntimeException("no review"));

        assertThat(findReview).isNotNull();
        assertThat(findReview.getPurchaseProduct().getId()).isEqualTo(purchaseProduct.getId());
    }

}