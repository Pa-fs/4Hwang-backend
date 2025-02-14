package com.green.sahwang.mypage.service;

import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.*;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import com.green.sahwang.mypage.dto.WishListCategoryDto;
import com.green.sahwang.mypage.dto.req.ApproveVerifiedSaleReqDto;
import com.green.sahwang.mypage.dto.req.MemberInfoReqDto;
import com.green.sahwang.mypage.dto.req.ReviewCreateReqDto;
import com.green.sahwang.mypage.dto.req.ReviewUpdateReqDto;
import com.green.sahwang.mypage.dto.res.*;
import com.green.sahwang.sale.mapper.SaleMapper;
import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.pendingsale.repository.PendingSaleRepository;
import com.green.sahwang.repository.*;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.entity.enumtype.UsedProductType;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import com.green.sahwang.verifiedsale.entity.VerifiedSale;
import com.green.sahwang.verifiedsale.repository.VerifiedSaleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{

    private final MemberRepository memberRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final WishCategoryRepository wishCategoryRepository;
    private final WishProductRepository wishProductRepository;
    private final ModelMapper modelMapper;
    private final ReviewRepository reviewRepository;
    private final ReviewImageRepository reviewImageRepository;
    private final ProductRepository productRepository;
    private final PendingSaleRepository pendingSaleRepository;
    private final VerifiedSaleRepository verifiedSaleRepository;
    private final UsedProductRepository usedProductRepository;
    private final FavoriteRepository favoriteRepository;

    private final SaleMapper saleMapper;

    @Transactional
    public OrderProgressResDto getOrderProgress(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Purchase purchase = purchaseRepository.findTopByMemberAndStatusOrderByPurchaseDateDesc(member, true)
                .orElseThrow(() -> new BizException(ErrorCode.NO_PURCHASE));

        OrderProgressResDto orderProgressResDto = new OrderProgressResDto();
        orderProgressResDto.setStatus(purchase.getPurchaseStatus());

        return orderProgressResDto;
    }

    @Transactional(readOnly = true)
    public SaleProgressResDto getSaleProgress(UserDetails userDetails){
//        Member member = memberRepository.findByEmail(userDetails.getUsername());
//        Sale sale = saleRepository.findTopByMemberOrderBySaleStartDateDesc(member)
//                .orElseThrow(() -> new BizException(ErrorCode.NO_SALE));
//
//        SaleProgressResDto saleProgressResDto = new SaleProgressResDto();
//        saleProgressResDto.setStatus(sale.getStatus());
//
//        return saleProgressResDto;
        return new SaleProgressResDto();
    }

    @Transactional
    public Page<OrderListResDto> getOrderList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        Pageable pageable = PageRequest.of(pageNum, size);

        return purchaseProductRepository.findPurchaseProductsByMemberId(member.getId(), pageable);
    }

    @Transactional(readOnly = true)
    public SaleListWithTotalCountResDto getSaleList(UserDetails userDetails, int pageNum, int size) {
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        Pageable pageable = PageRequest.of(pageNum, size);

        List<SaleListResDto> saleListResDtos = saleMapper.findSaleList(member.getId(), pageable);

        for (SaleListResDto saleListResDto : saleListResDtos) {
            if (saleListResDto.getPendingSaleId() != null) {
                saleListResDto.setUserImages(saleMapper.findUserImages(saleListResDto.getPendingSaleId()));
            }
            if (saleListResDto.getVerifiedSaleId() != null) {
                saleListResDto.setVerifiedImages(saleMapper.findVerifiedImages(saleListResDto.getVerifiedSaleId()));
            }
        }

        return SaleListWithTotalCountResDto.builder()
                .saleListResDtos(saleListResDtos)
                .totalCount(saleMapper.findSaleListTotalCount(member.getId()))
                .build();
    }

    @Transactional(readOnly = true)
    public List<WishListCategoryResDto> getWishCategoryList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<WishListCategoryDto> wishListCategoryDtoPage = wishCategoryRepository.findWishes(member, pageable);

        List<WishListCategoryResDto> wishListCategoryResDtoList = new ArrayList<>();
        for (WishListCategoryDto wishListCategoryDto : wishListCategoryDtoPage){
            Product product = productRepository.findById(wishListCategoryDto.getId()).orElseThrow();
            List<PendingSale> pendingSaleList = pendingSaleRepository.findAllByProduct(product);
            List<VerifiedSale> verifiedSaleList = verifiedSaleRepository.findAllByPendingSaleIn(pendingSaleList);
            List<UsedProduct> usedProductList = usedProductRepository.findAllByVerifiedSaleIn(verifiedSaleList);
            WishListCategoryResDto wishListCategoryResDto = new WishListCategoryResDto();
            wishListCategoryResDto.setWishListCategoryDto(wishListCategoryDto);
            wishListCategoryResDto.setProductCount(usedProductList.size());
            wishListCategoryResDto.setBrandName(product.getBrand().getName());
            wishListCategoryResDtoList.add(wishListCategoryResDto);
        }
        return wishListCategoryResDtoList;
    }

    @Transactional
    public List<WishListProductResDto> getWishProductList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<WishProduct> wishProductPage = wishProductRepository.findWishProductByMemberId(member.getId(), pageable);

        return wishProductPage.stream()
                .map(wp -> WishListProductResDto.builder()
                        .productId(wp.getUsedProduct().getId())
                        .productName(wp.getUsedProduct().getVerifiedSale().getProductName())
                        .price(wp.getUsedProduct().getVerifiedSale().getVerifiedSellingPrice())
                        .size(wp.getUsedProduct().getVerifiedSale().getProductSize())
                        .gradeType(wp.getUsedProduct().getVerifiedSale().getSaleGrade().getGradeType())
                        .brandName(wp.getUsedProduct().getVerifiedSale().getBrandName())
                        .userSaleImages(wp.getUsedProduct().getVerifiedSale().getPendingSale().getUserSaleImages()
                                .stream().map(image -> ImageResDto.builder()
                                .path(image.getPath())
                                .filename(image.getFilename())
                                .fileDesc(image.getFileDesc())
                                .build())
                        .toList())
                        .build())
                .toList();
    }

    @Transactional(readOnly = true)
    public List<MyReviewResDto> getReviewList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Pageable pageable = PageRequest.of(pageNum, size);

        Page<Object[]> myReviews = reviewImageRepository.findMyReviews(member.getId(), pageable);
        int reviewCount = reviewImageRepository.reviewCount(member.getId());

        return myReviews.stream().map(row -> new MyReviewResDto(
                (Long) row[0],
                (String) row[1],
                (String) row[2],
                ((Timestamp) row[3]).toLocalDateTime(),
                (Double) row[4],
                (Long) row[5],
                (Long) row[6],
                (String) row[7],
                (Integer) row[8],
                reviewCount
        )).toList();

    }

    @Transactional
    public void reviewCreate(UserDetails userDetails, MultipartFile file, ReviewCreateReqDto reviewCreateReqDto){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        PurchaseProduct purchaseProduct = purchaseProductRepository.findById(reviewCreateReqDto.getPurchaseProductId()).orElseThrow(() -> new BizException(ErrorCode.NO_PURCHASE_PRODUCT));
        Review review = new Review();
        review.setPurchaseProduct(purchaseProduct);
        review.setContent(reviewCreateReqDto.getContent());
        review.setReviewCreationDate(LocalDateTime.now());
        review.setImage(file.getOriginalFilename());
        review.setStar(reviewCreateReqDto.getStar());
        review.setMember(member);
        Review saved = reviewRepository.save(review);

        reviewCreateReqDto.getReviewImageReqDto().setReviewId(saved.getId());
    }

    @Transactional
    public void reviewUpdate(UserDetails userDetails, ReviewUpdateReqDto reviewUpdateReqDto){
        Review review = reviewRepository.findById(reviewUpdateReqDto.getReviewId()).orElseThrow();
        review.setReviewModifiedDate(LocalDateTime.now());
        review.setContent(reviewUpdateReqDto.getContent());
        reviewRepository.save(review);
    }

    @Transactional
    public void reviewDelete(UserDetails userDetails, Long reviewId){
        Review review = reviewRepository.findById(reviewId).orElseThrow();
        favoriteRepository.deleteAllByReview(review);
        reviewImageRepository.deleteById(review.getId());
        reviewRepository.deleteById(reviewId);
    }

    @Transactional
    public MemberInfoResDto updateMemberInfo(UserDetails userDetails, MemberInfoReqDto memberInfoReqDto){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        member.setNickName(memberInfoReqDto.getNickName());
        member.setAddress(memberInfoReqDto.getAddress());
        member.setName(memberInfoReqDto.getName());
        member.setPhoneNum(memberInfoReqDto.getPhoneNum());
        member.setEmail(memberInfoReqDto.getEmail());
        member.setGender(memberInfoReqDto.getGender());
        memberRepository.save(member);

        return modelMapper.map(member, MemberInfoResDto.class);
    }

    @Override
    @Transactional
    public void approveVerifiedSale(UserDetails userDetails, ApproveVerifiedSaleReqDto approveVerifiedSaleReqDto) {
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        PendingSale pendingSale = pendingSaleRepository.findById(approveVerifiedSaleReqDto.getPendingSaleId())
                .orElseThrow(() -> new BizException(ErrorCode.NO_PENDING_SALE));

        if (!Objects.equals(pendingSale.getMember().getId(), member.getId())) {
            throw new BizException(ErrorCode.NO_ACCEPT_MEMBER);
        }

        UsedProduct usedProduct = UsedProduct.builder()
                .verifiedSale(pendingSale.getVerifiedSale())
                .createdDate(LocalDateTime.now())
                .usedProductType(UsedProductType.USER_ACCEPT)
                .build();

        pendingSale.setExceptedSellingPrice(approveVerifiedSaleReqDto.getSalesPrice());
        usedProduct.getVerifiedSale().getPendingSale().setInspectionStatus(InspectionStatus.SELLING);
        usedProductRepository.save(usedProduct);
        pendingSaleRepository.save(pendingSale);
    }

    @Override
    @Transactional
    public void rejectVerifiedSale(UserDetails userDetails, Long pendingSaleId) {
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        PendingSale pendingSale = pendingSaleRepository.findById(pendingSaleId)
                .orElseThrow(() -> new BizException(ErrorCode.NO_PENDING_SALE));

        if (!Objects.equals(pendingSale.getMember().getId(), member.getId())) {
            throw new BizException(ErrorCode.NO_ACCEPT_MEMBER);
        }

        UsedProduct usedProduct = UsedProduct.builder()
                .verifiedSale(pendingSale.getVerifiedSale())
                .modifiedDate(LocalDateTime.now())
                .usedProductType(UsedProductType.USER_REJECT)
                .build();

        if(Objects.nonNull(usedProduct.getVerifiedSale())) {
            usedProduct.getVerifiedSale().getPendingSale().setInspectionStatus(InspectionStatus.REJECTED);
            usedProductRepository.save(usedProduct);
        } else {
            pendingSale.setInspectionStatus(InspectionStatus.REJECTED);
        }
        pendingSaleRepository.save(pendingSale);
    }

}
