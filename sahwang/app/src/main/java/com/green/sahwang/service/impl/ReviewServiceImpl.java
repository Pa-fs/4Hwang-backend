package com.green.sahwang.service.impl;

import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.repository.PurchaseProductRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.repository.ReviewRepository;
import com.green.sahwang.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final PurchaseRepository purchaseRepository;

    public int reviewCount(Product product){
        // 리뷰 수를 구하려면 productId, purchaseProductId 필요
        // purchaseProduct -> purchaseId -> purchaseEntity -> 구매완료인지 체크해야함

        List<Purchase> purchases = purchaseRepository.findAllByPurchaseStatus(PurchaseStatus.COMPLETED);

        List<PurchaseProduct> purchaseProducts = purchaseProductRepository.findByProductIdAndPurchaseIn(product.getId(), purchases);

        List<Review> reviews = reviewRepository.findAllByPurchaseProductIn(purchaseProducts);

        return reviews.size();
    }

}
