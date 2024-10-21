package com.green.sahwang.service;

import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.PurchaseProductRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewServiceTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PurchaseProductRepository purchaseProductRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ReviewService reviewService;
    static Candle candle = new Candle();


    @BeforeEach
    void setUp(){

        Purchase purchase1 = new Purchase();
        Purchase purchase2 = new Purchase();
        Purchase purchase3 = new Purchase();

        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchase1);
        purchases.add(purchase2);
        purchases.add(purchase3);

        purchase1.setPurchaseStatus(PurchaseStatus.COMPLETED);
        purchase2.setPurchaseStatus(PurchaseStatus.COMPLETED);

        purchaseRepository.saveAll(purchases);

        candle.setName("리뷰테스트");
        productRepository.save(candle);

        List<PurchaseProduct> purchaseProducts = new ArrayList<>();

        for(Purchase purchase : purchases){
            if(purchase.getPurchaseStatus() == PurchaseStatus.COMPLETED) {
                Review review = new Review();
                PurchaseProduct purchaseProduct = new PurchaseProduct();
                purchaseProduct.setPurchase(purchase);
                purchaseProduct.setProduct(candle);
                purchaseProducts.add(purchaseProduct);
                purchaseProductRepository.save(purchaseProduct);
                review.setPurchaseProduct(purchaseProduct);
                reviewRepository.save(review);
            }
        }

    }

    @Test
    void testReviewService(){

        Product product = productRepository.findById(candle.getId()).orElse(null);

        int reviewCount = reviewService.reviewCount(product);

        assertThat(reviewCount).isEqualTo(2);

    }

}