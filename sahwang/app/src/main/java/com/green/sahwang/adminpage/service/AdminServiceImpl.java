package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.res.MemberManageResDto;
import com.green.sahwang.adminpage.dto.res.ReviewManageResDto;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.repository.ReviewRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final PurchaseRepository purchaseRepository;

    @Transactional
    public List<MemberManageResDto> getMembers(){
        List<Member> memberList = memberRepository.findAll();

        List<MemberManageResDto> memberManageResDtoList = new ArrayList<>();
        for (Member member : memberList){
            List<Review> reviewList = reviewRepository.findAllByMember(member);
            List<Purchase> purchaseList = purchaseRepository.findAllByMemberAndPurchaseStatus(member, PurchaseStatus.COMPLETED);
            MemberManageResDto memberManageResDto = new MemberManageResDto();
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
    public List<MemberManageResDto> getMembersByRole(MemberRole role){
        List<Member> memberList = memberRepository.findAllByRole(role);

        List<MemberManageResDto> memberManageResDtoList = new ArrayList<>();
        for (Member member : memberList){
            List<Review> reviewList = reviewRepository.findAllByMember(member);
            List<Purchase> purchaseList = purchaseRepository.findAllByMemberAndPurchaseStatus(member, PurchaseStatus.COMPLETED);
            MemberManageResDto memberManageResDto = new MemberManageResDto();
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
    public List<ReviewManageResDto> getReviews(String sort){
        List<Review> reviewList = reviewRepository.findAll();

        Stream<Review> reviewStream = reviewList.stream();

        return null;
    }

}
