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
import com.green.sahwang.repository.FavoriteRepository;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.repository.ReviewRepository;
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
            MemberManageResDto memberManageResDto = new MemberManageResDto();
            memberManageResDto.setMemberId(member.getId());
            memberManageResDto.setProfileImage(member.getProfileImage());
            memberManageResDto.setName(member.getName());
            memberManageResDto.setPhoneNum(member.getPhoneNum());
            memberManageResDto.setEmail(member.getEmail());
            memberManageResDto.setRole(member.getRole());
            memberManageResDto.setJoinDate(member.getJoinDate());
            memberManageResDto.setWithdrawDate(member.getWithdrawDate());
            memberManageResDto.setLastLoginDate(member.getLastLoginDate());
            memberManageResDto.setNickName(member.getNickName());
            memberManageResDto.setAdReceived(member.getAdReceived());
            memberManageResDto.setWarnCount(member.getWarnCount());
            memberManageResDto.setPurchaseCount(purchaseList.size());
            memberManageResDto.setReviewCount(reviewList.size());
            memberManageResDtoList.add(memberManageResDto);
        }
        return memberManageResDtoList;
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
    public List<ReviewManageResDto> getReviews(int pageNum, int size){
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<ReviewManageDto> reviewManageDtoPage = reviewRepository.findReviews(pageable);

        return reviewManageDtoPage.stream()
                .map(reviewManageDto -> {
                    List<Favorite> favoriteList = favoriteRepository.findAllByReviewId(reviewManageDto.getReviewId());
                    return new ReviewManageResDto(reviewManageDto, favoriteList.size());
                }).toList();
    }

    @Transactional
    public List<ReviewManageResDto> getReviewsBySort(String sort, int pageNum, int size){
        Sort sortByOptions = getSortByOptions(sort);

        Pageable pageable = PageRequest.of(pageNum, size, sortByOptions);
        Page<ReviewManageDto> reviewManageDtoPage = reviewRepository.findReviews(pageable);

        return reviewManageDtoPage.stream()
                .map(reviewManageDto -> {
                    List<Favorite> favoriteList = favoriteRepository.findAllByReviewId(reviewManageDto.getReviewId());
                    return new ReviewManageResDto(reviewManageDto, favoriteList.size());
                }).toList();
    }

    private Sort getSortByOptions(String sort){
        return switch (sort.toLowerCase()) {
            case "category" -> Sort.by("p.dtype").ascending();
            case "productname" -> Sort.by("pp.productName").ascending();
            case "starasc" -> Sort.by("star").ascending();
            case "stardesc" -> Sort.by("star").descending();
            default -> null;
        };
    }

}
