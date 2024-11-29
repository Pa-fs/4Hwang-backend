package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.DetailReviewResDto;
import com.green.sahwang.detail.dto.response.FavoriteCheckedResDto;
import com.green.sahwang.detail.dto.response.ReviewResDto;
import com.green.sahwang.entity.*;
import com.green.sahwang.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductDetailPagePageServiceImplTest {

    @Autowired
    ProductDetailPageService productDetailPageService;

    @Autowired
    SaleProductRepository saleProductRepository;

    @Autowired
    SalePaymentRepository salePaymentRepository;

    @Autowired
    ProductImageRepository productImageRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PurchaseProductRepository purchaseProductRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FavoriteRepository favoriteRepository;

    private Product product;
    private PurchaseProduct purchaseProduct;
    private Member member;
    private Review review;
    private UserDetails userDetails;
    private Favorite favorite;

    @BeforeEach
    void setup() {
        userDetails = User.withUsername("thdghckd111@naver.com")
                .password("")
                .roles("USER")
                .build();

        product = productRepository.findById(1L).orElseThrow();

        purchaseProduct = new PurchaseProduct();
        purchaseProduct.setProduct(product);
        purchaseProductRepository.save(purchaseProduct);

        member = memberRepository.findByEmail(userDetails.getUsername());

        review = new Review();
        review.setPurchaseProduct(purchaseProduct);
        review.setMember(member);
        review.setStar(4.0);
        review.setContent("굿굿");
        review = reviewRepository.save(review);

        favorite = new Favorite();
        favorite.setMember(member);
        favorite.setReview(review);
        favoriteRepository.save(favorite);
    }

//    @Transactional
//    @Test
//    void getDetailReviewInfo() {
//        DetailReviewResDto detailReviewInfo = productDetailPageService.getDetailReviewInfo(product.getId());
//        assertThat(detailReviewInfo).isNotNull();
//        log.info("detailReviewInfo : {}", detailReviewInfo);
//    }

//    @Transactional
//    @Test
//    void clickFavorite() {
//        assertThat(productDetailPageService.clickFavorite(review.getId(), userDetails)).isEqualTo("Success");
//    }

//    @Transactional
//    @Test
//    void getChecked(){
//        List<FavoriteCheckedResDto> checked = productDetailPageService.getChecked(product.getId(), userDetails);
//        assertThat(checked).isNotNull();
//    }

//    @Transactional
//    @Test
//    void cancelFavorite(){
//        assertThat(productDetailPageService.cancelFavorite(review.getId(), userDetails)).isEqualTo("Cancel");
//    }

}