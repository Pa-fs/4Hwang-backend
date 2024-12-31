package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.CategoryManageDto;
import com.green.sahwang.adminpage.dto.MemberManageDto;
import com.green.sahwang.adminpage.dto.ReviewManageDto;
import com.green.sahwang.adminpage.dto.res.*;
import com.green.sahwang.config.DateTimeUtils;
import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.repository.*;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import com.green.sahwang.verifiedsale.entity.VerifiedSale;
import com.green.sahwang.verifiedsale.repository.VerifiedSaleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final PurchaseRepository purchaseRepository;
    private final ReviewImageRepository reviewImageRepository;
    private final FavoriteRepository favoriteRepository;
    private final UsedProductRepository usedProductRepository;
    private final VerifiedSaleRepository verifiedSaleRepository;
    private final ProductRepository productRepository;
    private final SalePaymentRepository salePaymentRepository;
    private final PurchaseProductRepository purchaseProductRepository;

    @Transactional
    public MemberManageResDto getMembers(int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Member> memberList = memberRepository.findAll(pageable);

        List<MemberManageDto> memberManageDtoList = new ArrayList<>();
        for (Member member : memberList){
            List<Review> reviewList = reviewRepository.findAllByMember(member);
            int purchaseCount = purchaseRepository.purchaseListCountByMemberId(member.getId());
            MemberManageDto memberManageDto = new MemberManageDto();
            memberManageDto.setMemberId(member.getId());
            memberManageDto.setProfileImage(member.getProfileImage());
            memberManageDto.setName(member.getName());
            memberManageDto.setPhoneNum(member.getPhoneNum());
            memberManageDto.setEmail(member.getEmail());
            memberManageDto.setRole(member.getRole());
            memberManageDto.setJoinDate(member.getJoinDate());
            memberManageDto.setWithdrawDate(member.getWithdrawDate());
            memberManageDto.setLastLoginDate(member.getLastLoginDate());
            memberManageDto.setNickName(member.getNickName());
            memberManageDto.setAdReceived(member.getAdReceived());
            memberManageDto.setWarnCount(member.getWarnCount());
            memberManageDto.setPurchaseCount(purchaseCount);
            memberManageDto.setReviewCount(reviewList.size());
            memberManageDtoList.add(memberManageDto);
        }

        MemberManageResDto memberManageResDto = new MemberManageResDto();
        memberManageResDto.setMemberManageDtos(memberManageDtoList);
        memberManageResDto.setMemberCount(memberManageDtoList.size());
        return memberManageResDto;
    }

    @Transactional
    public MemberManageResDto getMembersByRole(String role, int pageNum, int size){
        MemberRole memberRole = MemberRole.valueOf(role.toUpperCase());
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Member> memberList = memberRepository.findAllByRole(memberRole, pageable);

        List<MemberManageDto> memberManageDtoList = new ArrayList<>();
        for (Member member : memberList){
            List<Review> reviewList = reviewRepository.findAllByMember(member);
            int purchaseCount = purchaseRepository.purchaseListCountByMemberId(member.getId());
            MemberManageDto memberManageDto = new MemberManageDto();
            memberManageDto.setMemberId(member.getId());
            memberManageDto.setProfileImage(member.getProfileImage());
            memberManageDto.setName(member.getName());
            memberManageDto.setPhoneNum(member.getPhoneNum());
            memberManageDto.setEmail(member.getEmail());
            memberManageDto.setRole(member.getRole());
            memberManageDto.setJoinDate(member.getJoinDate());
            memberManageDto.setWithdrawDate(member.getWithdrawDate());
            memberManageDto.setLastLoginDate(member.getLastLoginDate());
            memberManageDto.setNickName(member.getNickName());
            memberManageDto.setAdReceived(member.getAdReceived());
            memberManageDto.setWarnCount(member.getWarnCount());
            memberManageDto.setPurchaseCount(purchaseCount);
            memberManageDto.setReviewCount(reviewList.size());
            memberManageDtoList.add(memberManageDto);
        }

        MemberManageResDto memberManageResDto = new MemberManageResDto();
        memberManageResDto.setMemberManageDtos(memberManageDtoList);
        memberManageResDto.setMemberCount(memberManageDtoList.size());

        return memberManageResDto;
    }

    @Transactional
    public void memberRoleChange(Long memberId, String role){
        Member member = memberRepository.findById(memberId).orElseThrow();
        String memberRole;
        if (role.equalsIgnoreCase("USER")||role.equalsIgnoreCase("APPRAISER")||role.equalsIgnoreCase("ADMIN")){
            memberRole = role.toUpperCase();
            member.setRole(MemberRole.valueOf(memberRole));
            memberRepository.save(member);
        }
    }

    @Transactional
    public ReviewManageResDto getReviews(int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<ReviewManageDto> reviewManageDtoPage = reviewImageRepository.findReviews(pageable);
        List<Review> reviewList = reviewRepository.findAll();

        return new ReviewManageResDto(reviewManageDtoPage, reviewList.size());
    }

    @Transactional
    public ReviewManageResDto getReviewsBySort(String sort, int pageNum, int size){
        Sort sortByOptions = getSortByOptions(sort);
        Pageable pageable = PageRequest.of(pageNum, size, sortByOptions);
        Page<ReviewManageDto> reviewManageDtoPage = reviewImageRepository.findReviews(pageable);
        List<Review> reviewList = reviewRepository.findAll();

        return new ReviewManageResDto(reviewManageDtoPage, reviewList.size());
    }

    private Sort getSortByOptions(String sort){
        return switch (sort.toLowerCase()) {
            case "category" -> Sort.by("ps.categoryName").ascending();
            case "productname" -> Sort.by("pp.productName").ascending();
            case "starasc" -> Sort.by("r.star").ascending();
            case "stardesc" -> Sort.by("r.star").descending();
            default -> null;
        };
    }

    @Transactional
    public ReviewManageResDto getReviewBySearch(String searchKeyword, int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<ReviewManageDto> reviewManageDtoPage = reviewImageRepository.findReviewsBySearch(searchKeyword, pageable);
        return new ReviewManageResDto(reviewManageDtoPage, (int) reviewManageDtoPage.getTotalElements());
    }

    public void deleteReview(Long reviewId){
        reviewRepository.deleteById(reviewId);
    }

    @Transactional
    public ProductManageResDto getProducts(int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<ProductManageDto> productManageDtoPage = usedProductRepository.findUsedProducts(pageable);
        List<UsedProduct> usedProductList = usedProductRepository.findAll();
        List<VerifiedSale> verifiedSaleList = verifiedSaleRepository.findAllByUsedProductInAndRejectionReason(usedProductList, null);
        return new ProductManageResDto(productManageDtoPage, verifiedSaleList.size());
    }

    @Transactional
    public ProductManageResDto getProductsByStatus(String status, int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);
        return null;
    }

    @Transactional
    public CategoryManageResDto getCategories(int pageNum, int size){
        int offset = pageNum * size;
        List<Object[]> products = productRepository.findProducts(size, offset);
        List<CategoryManageDto> categoryManageDtoList = products.stream().map(row -> new CategoryManageDto(
                (Long) row[0],
                (String) row[1],
                (Integer) row[2],
                (String) row[3],
                (String) row[4],
                ((BigDecimal) row[5]).longValue(),
                (String) row[6]
        )).toList();
        int totalProducts = productRepository.countTotalProducts();
        return new CategoryManageResDto(categoryManageDtoList, totalProducts);
    }

    @Transactional
    public CategoryManageResDto getCategoriesByStatus(String status, int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);
        return new CategoryManageResDto();
    }

    @Transactional
    public Page<OrderManageResDto> getOrders(int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);

        return purchaseProductRepository.findOrders(pageable);
    }

    @Transactional
    public OrderManageResDto getOrdersByStatus(String status, int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);

        return new OrderManageResDto();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RevenueResDto> getRevenues(String email, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay(); // 00:00:00
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59); // 23:59:59
        List<SalePayment> salePayments = salePaymentRepository.findRevenue(startDateTime, endDateTime);
        return salePayments.stream()
                .map(salePayment -> RevenueResDto.builder()
                        .usedProductId(salePayment.getUsedProduct().getId())
                        .totalPrice(salePayment.getFinalPrice())
                        .revenue((int)(salePayment.getFinalPrice() * 0.05))
                        .saleDate(DateTimeUtils.format(salePayment.getCreatedDate()))
                        .build()
                ).toList();
    }
}
