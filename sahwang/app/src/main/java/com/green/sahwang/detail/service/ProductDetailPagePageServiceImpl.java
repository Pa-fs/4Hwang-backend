package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.*;
import com.green.sahwang.detail.error.SalePaymentException;
import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.*;
import com.green.sahwang.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductDetailPagePageServiceImpl implements ProductDetailPageService {

    private final SaleProductRepository saleProductRepository;
    private final SalePaymentRepository salePaymentRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final FavoriteRepository favoriteRepository;

    @Transactional
    public List<DetailChartResDto> getSaleProducts(Long productId){
        Optional<SaleProduct> optionalSaleProduct = saleProductRepository.findById(productId);

        salePaymentRepository.findBySaleProduct(optionalSaleProduct.orElse(null)).orElseThrow(()->new SalePaymentException("결제 완료된 판매 내역이 없습니다"));

        return optionalSaleProduct
                .stream()
                .map(saleProduct -> {
                    DetailChartResDto detailChartResDto = new DetailChartResDto();
                    detailChartResDto.setTradeCompletedDate(saleProduct.getTradeCompletedDate());
                    detailChartResDto.setTradePrice(saleProduct.getTradePrice());
                    return detailChartResDto;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public DetailImagesResDto getProductImages(Long productId){
        Product product = productRepository.findById(productId)
                .orElse(null);
        List<ProductImage> productImages = productImageRepository.findByProduct(product);

        List<ImageResDto> imageResDtoList = new ArrayList<>();
        for (ProductImage productImage : productImages) {
            imageResDtoList.add(new ImageResDto(productImage.getFilename(), productImage.getPath(), productImage.getFileDesc()));
        }
        DetailImagesResDto detailImagesResDto = new DetailImagesResDto();
        detailImagesResDto.setImages(imageResDtoList);

        return detailImagesResDto;
    }

    @Transactional
    public DetailReviewResDto getDetailReviewInfo(Long productId){
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByProductId(productId);
        List<Review> reviewList = reviewRepository.findAllByPurchaseProductIn(purchaseProductList);
        List<Member> memberList = new ArrayList<>();
        for (Review review : reviewList){
            memberList.add(review.getMember());
            log.info("memberList.size() : {}", memberList.size());
        }

        log.info("memberList : {}", memberList);

        List<MemberDetailReviewResDto> memberDetailReviewResDtoList = new ArrayList<>();
        for (Member member : memberList){
            memberDetailReviewResDtoList.add(new MemberDetailReviewResDto(member.getNickName(), member.getProfileImage()));
        }

        List<ReviewResDto> reviewResDtoList = new ArrayList<>();

        for (int i = 0; i < reviewList.size(); i++){
            Review review = reviewList.get(i);
            MemberDetailReviewResDto memberDetailReviewResDto = memberDetailReviewResDtoList.get(i);

            ReviewResDto reviewResDto = new ReviewResDto();
            reviewResDto.setMemberDetailReviewResDto(memberDetailReviewResDto);
            reviewResDto.setStar(review.getStar());
            reviewResDto.setContent(review.getContent());
            reviewResDto.setReviewCreationDate(review.getReviewCreationDate());
            reviewResDto.setReviewModifiedDate(review.getReviewModifiedDate());

            reviewResDtoList.add(reviewResDto);
        }

        int oneStarCount = 0;
        int twoStarCount = 0;
        int threeStarCount = 0;
        int fourStarCount = 0;
        int fiveStarCount = 0;
        double totalStars = 0.0;

        for (Review review : reviewList) {
            double star = review.getStar();
            totalStars += star; // 총 별점 합계

            if (star == 1.0) oneStarCount++;
            else if (star == 2.0) twoStarCount++;
            else if (star == 3.0) threeStarCount++;
            else if (star == 4.0) fourStarCount++;
            else if (star == 5.0) fiveStarCount++;
        }

        // 별점 평균 계산
        double averageStar = reviewList.isEmpty() ? 0.0 : totalStars / reviewList.size();

        List<Favorite> favoriteList = favoriteRepository.findAllByReviewIn(reviewList);

        DetailReviewResDto detailReviewResDto = new DetailReviewResDto();
        detailReviewResDto.setReviewResDtoList(reviewResDtoList);
        detailReviewResDto.setFavoriteCount(favoriteList.size());
        detailReviewResDto.setStarAverage(averageStar);
        detailReviewResDto.setOneStarCount(oneStarCount);
        detailReviewResDto.setTwoStarCount(twoStarCount);
        detailReviewResDto.setThreeStarCount(threeStarCount);
        detailReviewResDto.setFourStarCount(fourStarCount);
        detailReviewResDto.setFiveStarCount(fiveStarCount);

        return detailReviewResDto;
    }

    @Transactional
    public List<ReviewResDto> getReviewPages(Long productId, int pageNum, int size){
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByProductId(productId);

        Pageable pageable = PageRequest.of(pageNum, size);

        Page<Review> reviewList = reviewRepository.findAllByPurchaseProductIn(purchaseProductList, pageable);

        List<ReviewResDto> reviewResDtoList = new ArrayList<>();

        for(Review review : reviewList.getContent()){
            Member member = review.getMember();
            MemberDetailReviewResDto memberDetailReviewResDto = new MemberDetailReviewResDto(
                    member.getNickName(), member.getProfileImage()
            );

            ReviewResDto reviewResDto = new ReviewResDto();
            reviewResDto.setStar(review.getStar());
            reviewResDto.setContent(review.getContent());
            reviewResDto.setReviewCreationDate(review.getReviewCreationDate());
            reviewResDto.setReviewModifiedDate(review.getReviewModifiedDate());
            reviewResDto.setMemberDetailReviewResDto(memberDetailReviewResDto);

            reviewResDtoList.add(reviewResDto);
        }

        return reviewResDtoList;
    }

    public List<FavoriteCheckedResDto> getChecked(Long productId, UserDetails userDetails){
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByProductId(productId);
        List<Review> reviewList = reviewRepository.findAllByPurchaseProductIn(purchaseProductList);
        List<Favorite> favoriteList = favoriteRepository.findAllByReviewIn(reviewList);
        List<Member> memberList = memberRepository.findAllByEmail(userDetails.getUsername());

        Set<Long> favoriteMemberIds = favoriteList.stream()
                .map(favorite -> favorite.getMember().getId())
                .collect(Collectors.toSet());

        List<FavoriteCheckedResDto> favoriteCheckedResDtoList = memberList.stream()
                .map(member -> {
                    Boolean isChecked = favoriteMemberIds.contains(member.getId());
                    FavoriteCheckedResDto favoriteCheckedResDto = new FavoriteCheckedResDto();
                    favoriteCheckedResDto.setChecked(isChecked);
                    return favoriteCheckedResDto;
                })
                .toList();

        return favoriteCheckedResDtoList;
    }

}
