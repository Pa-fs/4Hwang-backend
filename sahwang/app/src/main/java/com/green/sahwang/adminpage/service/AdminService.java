package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.res.MemberManageResDto;
import com.green.sahwang.adminpage.dto.ReviewManageDto;
import com.green.sahwang.adminpage.dto.res.ReviewManageResDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {

    List<MemberManageResDto> getMembers(int pageNum, int size);

    List<MemberManageResDto> getMembersByRole(String role, int pageNum, int size);

    void memberRoleChange(Long memberId, String role);

    List<ReviewManageResDto> getReviews(int pageNum, int size);

    List<ReviewManageResDto> getReviewsBySort(String sort, int pageNum, int size);

}
