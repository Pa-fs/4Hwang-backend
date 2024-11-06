package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.*;
import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.*;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductDetailPagePageServiceImpl implements ProductDetailPageService {

    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final PurchasePaymentRepository purchasePaymentRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final FavoriteRepository favoriteRepository;
    private final ReviewImageRepository reviewImageRepository;
    private final DetailImageRepository detailImageRepository;
    private final Path imagePath;

    public ProductDetailPagePageServiceImpl(ProductImageRepository productImageRepository,
                                            ProductRepository productRepository,
                                            PurchaseProductRepository purchaseProductRepository,
                                            PurchasePaymentRepository purchasePaymentRepository,
                                            ReviewRepository reviewRepository,
                                            MemberRepository memberRepository,
                                            FavoriteRepository favoriteRepository,
                                            ReviewImageRepository reviewImageRepository,
                                            DetailImageRepository detailImageRepository) {
        this.productImageRepository = productImageRepository;
        this.productRepository = productRepository;
        this.purchaseProductRepository = purchaseProductRepository;
        this.purchasePaymentRepository = purchasePaymentRepository;
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
        this.favoriteRepository = favoriteRepository;
        this.reviewImageRepository = reviewImageRepository;
        this.detailImageRepository = detailImageRepository;
        this.imagePath = Paths.get("images/file").toAbsolutePath();

        try {
            Files.createDirectories(this.imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<DetailChartResDto> getSaleProducts(Long productId, int size){
        Product product = productRepository.findById(productId).orElseThrow();
        Product product1 = productRepository.findByNameAndSize(product.getName(), size);
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByProduct(product1);
        List<PurchasePayment> purchasePaymentList = purchasePaymentRepository.findAllByPurchaseProductIn(purchaseProductList);

        if (purchasePaymentList.isEmpty()){
            throw new BizException(ErrorCode.NO_PURCHASE_PRODUCT);
        }

        List<DetailChartResDto> detailChartResDtoList = new ArrayList<>();

        for (PurchasePayment purchasePayment : purchasePaymentList){
            DetailChartResDto detailChartResDto = new DetailChartResDto();
            detailChartResDto.setTradePrice(product.getPrice());
            detailChartResDto.setTradeCompletedDate(purchasePayment.getCreatedDate());

            detailChartResDtoList.add(detailChartResDto);
        }

        return detailChartResDtoList;
    }

    @Transactional
    public DetailImagesResDto getProductImages(Long productId){
        Product product = productRepository.findById(productId)
                .orElse(null);
        List<ProductImage> productImages = productImageRepository.findAllByProduct(product);

        List<ImageResDto> imageResDtoList = new ArrayList<>();
        for (ProductImage productImage : productImages) {
            imageResDtoList.add(new ImageResDto(productImage.getFilename(), productImage.getPath(), productImage.getFileDesc()));
        }
        DetailImagesResDto detailImagesResDto = new DetailImagesResDto();
        detailImagesResDto.setImages(imageResDtoList);

        return detailImagesResDto;
    }

    @Transactional
    public List<DetailProductInfoResDto> getDetailProductInfo(Long productId){
        Product product = productRepository.findById(productId).orElseThrow();
        List<Product> productList = productRepository.findAllByName(product.getName());

        List<DetailProductInfoResDto> detailProductInfoResDtoList = new ArrayList<>();

        for (Product product1 : productList){
            DetailProductInfoResDto detailProductInfoResDto = new DetailProductInfoResDto();
            detailProductInfoResDto.setBrandName(product1.getBrand().getName());
            detailProductInfoResDto.setProductName(product1.getName());
            detailProductInfoResDto.setPrice(product1.getPrice());
            detailProductInfoResDto.setProductId(product1.getId());
            detailProductInfoResDto.setSize(product1.getSize());

            detailProductInfoResDtoList.add(detailProductInfoResDto);
        }

        return detailProductInfoResDtoList;
    }

    @Transactional
    public DetailReviewInfoResDto getDetailReviewInfo(Long productId){
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByProductId(productId);
        List<Review> reviewList = reviewRepository.findAllByPurchaseProductIn(purchaseProductList);
        List<Favorite> favoriteList = favoriteRepository.findAllByReviewIn(reviewList);

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

        DetailReviewInfoResDto detailReviewInfoResDto = new DetailReviewInfoResDto();
        detailReviewInfoResDto.setStarAverage(averageStar);
        detailReviewInfoResDto.setOneStarCount(oneStarCount);
        detailReviewInfoResDto.setTwoStarCount(twoStarCount);
        detailReviewInfoResDto.setThreeStarCount(threeStarCount);
        detailReviewInfoResDto.setFourStarCount(fourStarCount);
        detailReviewInfoResDto.setFiveStarCount(fiveStarCount);
        detailReviewInfoResDto.setFavoriteCount(favoriteList.size());

        return detailReviewInfoResDto;
    }

    @Transactional
    public void saveDetailMainImage(MultipartFile file, ImageFileReqDto imageFileReqDto){
        try {
            String relativePath = "images/file/";
            String fileName = file.getOriginalFilename();
            String filePath = relativePath + File.separator + fileName;

            String absoluteFilePath = imagePath.toString() + File.separator + fileName;

            File dest = new File(absoluteFilePath);
            file.transferTo(dest);

            Product product = productRepository.findById(imageFileReqDto.getProductId()).orElseThrow();

            DetailImage detailImage = DetailImage.builder()
                    .product(product)
                    .path(filePath)
                    .filename(imageFileReqDto.getName())
                    .fileDesc(imageFileReqDto.getDesc())
                    .build();
            detailImageRepository.save(detailImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public DetailMainImageResDto getDetailMainPageImage(Long productId){
        Product product = productRepository.findById(productId).orElseThrow();
        DetailImage detailImage = detailImageRepository.findByProduct(product);
        DetailMainImageResDto detailMainImageResDto = new DetailMainImageResDto();
        detailMainImageResDto.setFilename(detailImage.getFilename());

        return detailMainImageResDto;
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

            List<Favorite> favoriteList = favoriteRepository.findAllByReview(review);

            ReviewImage reviewImage = reviewImageRepository.findByReview(review);
            ReviewImageResDto reviewImageResDto = null;

            if(reviewImage != null){
                reviewImageResDto = new ReviewImageResDto();
                reviewImageResDto.setPath(reviewImage.getPath());
                reviewImageResDto.setFilename(reviewImage.getFilename());
                reviewImageResDto.setFileDesc(reviewImage.getFileDesc());
            }

            ReviewResDto reviewResDto = new ReviewResDto();
            reviewResDto.setReviewId(review.getId());
            reviewResDto.setStar(review.getStar());
            reviewResDto.setContent(review.getContent());
            reviewResDto.setReviewCreationDate(review.getReviewCreationDate());
            reviewResDto.setReviewModifiedDate(review.getReviewModifiedDate());
            reviewResDto.setMemberDetailReviewResDto(memberDetailReviewResDto);
            reviewResDto.setReviewImageResDto(reviewImageResDto);
            reviewResDto.setFavoriteCount(favoriteList.size());

            reviewResDtoList.add(reviewResDto);
        }

        return reviewResDtoList;
    }

    @Transactional
    public List<ReviewImageResDto> getReviewImages(Long productId){
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByProductId(productId);
        List<Review> reviewList = reviewRepository.findAllByPurchaseProductIn(purchaseProductList);
        List<ReviewImage> reviewImageList = reviewImageRepository.findAllByReviewIn(reviewList);

        return reviewImageList.stream()
                .sorted((img1, img2) -> Long.compare(img2.getId(), img1.getId()))
                .limit(20)
                .map(img -> {
                    ReviewImageResDto reviewImageResDto = new ReviewImageResDto();
                    reviewImageResDto.setFileDesc(img.getFileDesc());
                    reviewImageResDto.setPath(img.getPath());
                    reviewImageResDto.setFilename(img.getFilename());
                    return reviewImageResDto;
                })
                .toList();
    }

    @Transactional
    public List<FavoriteCheckedResDto> getChecked(Long productId, UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByProductId(productId);
        List<Review> reviewList = reviewRepository.findAllByPurchaseProductIn(purchaseProductList);
        List<Favorite> favoriteList = favoriteRepository.findAllByReviewIn(reviewList);

        Set<Long> favoriteReviewIds = favoriteList.stream()
                .filter(favorite -> favorite.getMember().getId().equals(member.getId()))
                .map(favorite -> favorite.getReview().getId())
                .collect(Collectors.toSet());

        List<FavoriteCheckedResDto> favoriteCheckedResDtoList = reviewList.stream()
                .map(review -> {
                    boolean isChecked = favoriteReviewIds.contains(review.getId());
                    return new FavoriteCheckedResDto(isChecked);
                })
                .toList();

        return favoriteCheckedResDtoList;
    }

    @Transactional
    public String clickFavorite(Long reviewId, UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new NoSuchElementException("잘못된 리뷰Id 입니다"));

        Favorite favorite = Favorite.builder()
                .review(review)
                .member(member)
                .build();

        favoriteRepository.save(favorite);
        return "Success";
    }

    @Transactional
    public String cancelFavorite(Long reviewId, UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new NoSuchElementException("잘못된 리뷰Id 입니다"));
        Favorite favorite = favoriteRepository.findByMemberAndReview(member, review);

        favoriteRepository.deleteById(favorite.getId());
        return "Cancel";
    }

}