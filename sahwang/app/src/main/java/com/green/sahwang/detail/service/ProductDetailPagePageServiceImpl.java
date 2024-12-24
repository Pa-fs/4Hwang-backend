package com.green.sahwang.detail.service;

import com.green.sahwang.config.DateTimeUtils;
import com.green.sahwang.detail.dto.DetailProductInfoDto;
import com.green.sahwang.detail.dto.response.*;
import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.*;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.pendingsale.entity.UserSaleImage;
import com.green.sahwang.pendingsale.repository.UserSaleImageRepository;
import com.green.sahwang.repository.*;
import com.green.sahwang.usedproduct.dto.VerifiedAndUserSaleImageResDto;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
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
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    private final UsedProductRepository usedProductRepository;
    private final UserSaleImageRepository userSaleImageRepository;
    private final Path imagePath;

    public ProductDetailPagePageServiceImpl(ProductImageRepository productImageRepository,
                                            ProductRepository productRepository,
                                            PurchaseProductRepository purchaseProductRepository,
                                            PurchasePaymentRepository purchasePaymentRepository,
                                            ReviewRepository reviewRepository,
                                            MemberRepository memberRepository,
                                            FavoriteRepository favoriteRepository,
                                            ReviewImageRepository reviewImageRepository,
                                            DetailImageRepository detailImageRepository,
                                            UsedProductRepository usedProductRepository,
                                            UserSaleImageRepository userSaleImageRepository) {
        this.productImageRepository = productImageRepository;
        this.productRepository = productRepository;
        this.purchaseProductRepository = purchaseProductRepository;
        this.purchasePaymentRepository = purchasePaymentRepository;
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
        this.favoriteRepository = favoriteRepository;
        this.reviewImageRepository = reviewImageRepository;
        this.detailImageRepository = detailImageRepository;
        this.usedProductRepository = usedProductRepository;
        this.userSaleImageRepository = userSaleImageRepository;
        this.imagePath = Paths.get("images/file").toAbsolutePath();

        try {
            Files.createDirectories(this.imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<DetailChartResDto> getSaleProducts(Long usedProductId){
        List<Object[]> reviewInfo = usedProductRepository.findChartInfo(usedProductId);

        return reviewInfo.stream().map(row -> new DetailChartResDto(
                (Long) row[0],
                (Long) row[1],
                (Long) row[2],
                ((Timestamp) row[3]).toLocalDateTime(),
                (Integer) row[4],
                (Integer) row[5]
        )).toList();
    }

    @Transactional
    public List<DetailChartResDto> getChartOneMonth(Long usedProductId){
        List<Object[]> reviewInfoOneMonth = usedProductRepository.findChartInfoOneMonth(usedProductId);

        return reviewInfoOneMonth.stream().map(row -> new DetailChartResDto(
                (Long) row[0],
                (Long) row[1],
                (Long) row[2],
                ((Timestamp) row[3]).toLocalDateTime(),
                (Integer) row[4],
                (Integer) row[5]
        )).toList();
    }

    @Transactional
    public List<DetailChartResDto> getChartSixMonth(Long usedProductId){
        List<Object[]> reviewInfoSixMonth = usedProductRepository.findChartInfoSixMonth(usedProductId);

        return reviewInfoSixMonth.stream().map(row -> new DetailChartResDto(
                (Long) row[0],
                (Long) row[1],
                (Long) row[2],
                ((Timestamp) row[3]).toLocalDateTime(),
                (Integer) row[4],
                (Integer) row[5]
        )).toList();
    }

    @Transactional
    public List<VerifiedAndUserSaleImageResDto> getProductImages(Long usedProductId){
//        Product product = productRepository.findById(productId)
//                .orElse(null);
//        List<ProductImage> productImages = productImageRepository.findAllByProduct(product);
//
//        List<ImageResDto> imageResDtoList = new ArrayList<>();
//        for (ProductImage productImage : productImages) {
//            imageResDtoList.add(new ImageResDto(productImage.getFilename(), productImage.getPath(), productImage.getFileDesc()));
//        }
//        DetailImagesResDto detailImagesResDto = new DetailImagesResDto();
//        detailImagesResDto.setImages(imageResDtoList);
        List<Object[]> byUsedProductId = usedProductRepository.findByUsedProductId(usedProductId);

        return byUsedProductId.stream().map(row -> new VerifiedAndUserSaleImageResDto(
                (String) row[0], // file_desc
                (String) row[1], // filename
                (String) row[2], // path
                (String) row[3]  // type ('Verified' or 'User')
        )).toList();
    }

    @Transactional
    public DetailProductInfoResDto getDetailProductInfo(Long usedProductId){
        DetailProductInfoDto detailProductInfoDto = usedProductRepository.findUsedProductInfo(usedProductId);
        UsedProduct usedProduct = usedProductRepository.findById(detailProductInfoDto.getUsedProductId()).orElseThrow();
        List<ImageResDto> imageResDtoList = usedProduct.getVerifiedSale().getPendingSale().getUserSaleImages().stream().map(userSaleImage -> ImageResDto.builder()
                .filename(userSaleImage.getFilename())
                .fileDesc(userSaleImage.getFileDesc())
                .path(userSaleImage.getPath())
                .build()).toList();
        return new DetailProductInfoResDto(detailProductInfoDto, imageResDtoList);
    }

    @Transactional
    public DetailReviewInfoResDto getDetailReviewInfo(Long usedProductId){
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByUsedProductId(usedProductId);
        List<Review> reviewList = reviewRepository.findAllByPurchaseProductIn(purchaseProductList);

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
        detailReviewInfoResDto.setReviewCount(reviewList.size());

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
    public List<ReviewResDto> getReviewPages(Long usedProductId, int pageNum, int size){
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByUsedProductId(usedProductId);

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
    public List<ReviewImageResDto> getReviewImages(Long usedProductId){
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByUsedProductId(usedProductId);
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
    public List<FavoriteCheckedResDto> getChecked(Long usedProductId, UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByUsedProductId(usedProductId);

        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Review> reviewPage = reviewRepository.findAllByPurchaseProductIn(purchaseProductList, pageable);

        List<FavoriteCheckedResDto> favoriteCheckedResDtoList = new ArrayList<>();
        for (Review review : reviewPage.getContent()){
            Optional<Favorite> optionalFavorite = favoriteRepository.findByMemberAndReview(member, review);
            FavoriteCheckedResDto favoriteCheckedResDto = new FavoriteCheckedResDto();
            if (optionalFavorite.isPresent()){
                favoriteCheckedResDto.setReviewId(review.getId());
                favoriteCheckedResDto.setChecked(true);
            }
            else {
                favoriteCheckedResDto.setReviewId(review.getId());
                favoriteCheckedResDto.setChecked(false);
            }
            favoriteCheckedResDtoList.add(favoriteCheckedResDto);
        }

        return favoriteCheckedResDtoList;
    }

//    @Transactional
//    public FavoriteClickResDto clickFavorite(Long reviewId, UserDetails userDetails){
//        Member member = memberRepository.findByEmail(userDetails.getUsername());
//        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new NoSuchElementException("잘못된 리뷰Id 입니다"));
//
//        Favorite favorite = Favorite.builder()
//                .review(review)
//                .member(member)
//                .build();
//
//        favoriteRepository.save(favorite);
//
//        List<Favorite> favoriteList = favoriteRepository.findAllByReview(review);
//
//        FavoriteClickResDto favoriteClickResDto = new FavoriteClickResDto();
//        favoriteClickResDto.setFavoriteCount(favoriteList.size());
//        favoriteClickResDto.setChecked(true);
//        return favoriteClickResDto;
//    }
//
//    @Transactional
//    public FavoriteClickResDto cancelFavorite(Long reviewId, UserDetails userDetails){
//        Member member = memberRepository.findByEmail(userDetails.getUsername());
//        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new NoSuchElementException("잘못된 리뷰Id 입니다"));
//        Optional<Favorite> favorite = favoriteRepository.findByMemberAndReview(member, review);
//
//        FavoriteClickResDto favoriteClickResDto = new FavoriteClickResDto();
//        if (favorite.isPresent()) {
//            favoriteRepository.deleteById(favorite.get().getId());
//
//            List<Favorite> favoriteList = favoriteRepository.findAllByReview(review);
//
//
//            favoriteClickResDto.setFavoriteCount(favoriteList.size());
//            favoriteClickResDto.setChecked(false);
//        }
//        return favoriteClickResDto;
//    }

    @Transactional
    public FavoriteClickResDto clickFavorite(UserDetails userDetails, Long reviewId){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new NoSuchElementException("잘못된 리뷰Id 입니다"));
        Optional<Favorite> optionalFavorite = favoriteRepository.findByMemberAndReview(member, review);

        FavoriteClickResDto favoriteClickResDto = new FavoriteClickResDto();
        if(optionalFavorite.isEmpty()){
            Favorite favorite = Favorite.builder()
                    .review(review)
                    .member(member)
                    .build();
            favoriteRepository.save(favorite);

            List<Favorite> favoriteList = favoriteRepository.findAllByReview(review);

            favoriteClickResDto.setChecked(true);
            favoriteClickResDto.setFavoriteCount(favoriteList.size());
        }
        else {
            favoriteRepository.deleteById(optionalFavorite.get().getId());

            List<Favorite> favoriteList = favoriteRepository.findAllByReview(review);

            favoriteClickResDto.setChecked(false);
            favoriteClickResDto.setFavoriteCount(favoriteList.size());
        }

        return favoriteClickResDto;
    }

}