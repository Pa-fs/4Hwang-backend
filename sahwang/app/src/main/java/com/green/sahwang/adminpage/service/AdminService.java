package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.res.MemberManageResDto;
import com.green.sahwang.adminpage.dto.res.ReviewManageResDto;
import com.green.sahwang.entity.enumtype.MemberRole;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {

    List<MemberManageResDto> getMembers(int pageNum, int size);

    List<MemberManageResDto> getMembersByRole(String role, int pageNum, int size);

    void memberRoleChange(Long memberId, String role);

    Page<ReviewManageResDto> getReviews(int pageNum, int size);

    Page<ReviewManageResDto> getReviewsBySort(String sort, int pageNum, int size);

}
