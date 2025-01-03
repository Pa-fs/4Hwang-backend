package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.*;
import com.green.sahwang.adminpage.dto.res.*;
import com.green.sahwang.adminpage.mapper.StatisticsMapper;
import com.green.sahwang.config.DateTimeUtils;
import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.pendingsale.repository.PendingSaleRepository;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private final PendingSaleRepository pendingSaleRepository;
    private final StatisticsMapper statisticsMapper;

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
        favoriteRepository.deleteByReviewId(reviewId);
        reviewImageRepository.deleteByReviewId(reviewId);
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

    @Transactional
    public DashOrderResDto getDashOrders(){
        List<Object[]> dashOrders = purchaseProductRepository.findDashOrders();
        List<DashOrderListDto> dashOrderListDtoList = dashOrders.stream().map(row -> new DashOrderListDto(
                (Long) row[0],
                ((Timestamp) row[1]).toLocalDateTime(),
                (String) row[2],
                (String) row[3],
                (Integer) row[4],
                (String) row[5]
        )).toList();
        int dashOrderCount = purchaseProductRepository.getDashOrderCount();
        return new DashOrderResDto(dashOrderListDtoList, dashOrderCount);
    }

    @Transactional
    public DashPendingResDto getDashPendingSales(){
        List<Object[]> dashOrders = pendingSaleRepository.getDashPendingSales();
        List<DashPendingListDto> dashPendingListDtoList = dashOrders.stream().map(row -> new DashPendingListDto(
                (Long) row[0],
                (String) row[1],
                (String) row[2],
                ((Timestamp) row[3]).toLocalDateTime(),
                (String) row[4]
        )).toList();
        int dashOrderCount = pendingSaleRepository.getDashPendingSaleCount();
        return new DashPendingResDto(dashPendingListDtoList, dashOrderCount);
    }

    @Transactional
    public DashMemberJoinResDto getDashJoinMembers(){
        List<Object[]> joinMembers = memberRepository.getJoinMembers();
        List<DashMemberJoinListDto> dashMemberJoinListDtoList = joinMembers.stream().map(row -> new DashMemberJoinListDto(
                (Long) row[0],
                (String) row[1],
                (String) row[2],
                ((Timestamp) row[3]).toLocalDateTime()
        )).toList();

        int memberCount = memberRepository.joinMembers();
        return new DashMemberJoinResDto(dashMemberJoinListDtoList, memberCount);
    }

    @Transactional
    public DashMemberLogInResDto getDashLogInMembers(){
        List<Object[]> loginMembers = memberRepository.getLoginMembers();
        List<DashMemberLogInListDto> dashMemberLogInListDtoList = loginMembers.stream().map(row -> new DashMemberLogInListDto(
                (Long) row[0],
                (String) row[1],
                (String) row[2],
                ((Timestamp) row[3]).toLocalDateTime()
        )).toList();

        int memberCount = memberRepository.logInMembers();

        return new DashMemberLogInResDto(dashMemberLogInListDtoList, memberCount);
    }

    @Transactional
    public DashReviewResDto getDashReviews(){
        List<Object[]> dashReviews = reviewRepository.findDashReviews();
        List<DashReviewListDto> dashReviewListDtoList = dashReviews.stream().map(row -> new DashReviewListDto(
                (Long) row[0],
                (String) row[1],
                ((Timestamp) row[2]).toLocalDateTime(),
                (String) row[3],
                (String) row[4],
                (String) row[5],
                (Integer) row[6],
                (String) row[7]
        )).toList();

        int reviewCount = reviewRepository.getDashReviews();
        return new DashReviewResDto(dashReviewListDtoList, reviewCount);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NetProfitResDto> getNetProfit(String email, LocalDate startDate, LocalDate endDate, String day, String month, String year) {
        LocalDateTime startDateTime = startDate.atStartOfDay(); // 00:00:00
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59); // 23:59:59

        if (Objects.nonNull(day)) {
            return getDailyNetProfit(startDate, endDate, startDate.getYear(), startDate.getMonth().getValue());
        } else if (Objects.nonNull(month)) {
            return getMonthlyNetProfit(startDate, endDate, startDate.getYear());
        } else if (Objects.nonNull(year)) {
            return getYearlyNetProfit(startDate, endDate);
        }

        return null;
    }


    private List<NetProfitResDto> getDailyNetProfit(LocalDate startDate, LocalDate endDate, int year, int month) {
        return statisticsMapper.getDailyNetProfit(startDate, endDate, year, month);
    }

    private List<NetProfitResDto> getMonthlyNetProfit(LocalDate startDate, LocalDate endDate, int year) {
        return statisticsMapper.getMonthlyNetProfit(startDate, endDate, year);
    }

    private List<NetProfitResDto> getYearlyNetProfit(LocalDate startDate, LocalDate endDate) {
        return statisticsMapper.getYearlyNetProfit(startDate, endDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RevenueResDto> getRevenues(String email, LocalDate startDate, LocalDate endDate, String day, String month, String year) {
        LocalDateTime startDateTime = startDate.atStartOfDay(); // 00:00:00
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59); // 23:59:59

        if (Objects.nonNull(day)) {
            // 일별 매출 조회 쿼리 호출
            log.info("startDate.getYear() : {}", startDate.getYear());
            log.info("startDate.getMonth().getValue() : {}", startDate.getMonth().getValue());
            return getDailyRevenue(startDate, endDate, startDate.getYear(), startDate.getMonth().getValue());
        } else if (Objects.nonNull(month)) {
            // 월별 매출 조회 쿼리 호출
            return getMonthlyRevenue(startDate, endDate, startDate.getYear());
        } else if (Objects.nonNull(year)) {
            // 년별 매출 조회 쿼리 호출
            return getYearlyRevenue(startDate, endDate);
        }

        return null;
    }

    private List<RevenueResDto> getDailyRevenue(LocalDate startDate, LocalDate endDate, int year, int month) {
        return statisticsMapper.getDailyRevenue(startDate, endDate, year, month);
    }

    private List<RevenueResDto> getMonthlyRevenue(LocalDate startDate, LocalDate endDate, int year) {
        return statisticsMapper.getMonthlyRevenue(startDate, endDate, year);
    }

    private List<RevenueResDto> getYearlyRevenue(LocalDate startDate, LocalDate endDate) {
        return statisticsMapper.getYearlyRevenue(startDate, endDate);
    }
}
