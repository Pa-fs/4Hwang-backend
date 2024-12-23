package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.MemberManageDto;
import com.green.sahwang.adminpage.dto.ReviewManageDto;
import com.green.sahwang.adminpage.dto.res.MemberManageResDto;
import com.green.sahwang.adminpage.dto.res.ReviewManageResDto;
import com.green.sahwang.entity.Favorite;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public MemberManageResDto getMembers(int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Member> memberList = memberRepository.findAll(pageable);

        List<MemberManageDto> memberManageDtoList = new ArrayList<>();
        for (Member member : memberList){
            List<Review> reviewList = reviewRepository.findAllByMember(member);
            List<Purchase> purchaseList = purchaseRepository.findAllByMemberAndPurchaseStatus(member, PurchaseStatus.COMPLETED);
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
            memberManageDto.setPurchaseCount(purchaseList.size());
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
            List<Purchase> purchaseList = purchaseRepository.findAllByMemberAndPurchaseStatus(member, PurchaseStatus.COMPLETED);
            MemberManageDto memberManageDto = new MemberManageDto();
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
            memberManageDto.setPurchaseCount(purchaseList.size());
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

}
