package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.MemberManageDto;
import com.green.sahwang.adminpage.dto.res.MemberManageResDto;
import com.green.sahwang.adminpage.dto.res.ReviewManageResDto;

import java.util.List;

public interface AdminService {

    MemberManageResDto getMembers(int pageNum, int size);

    MemberManageResDto getMembersByRole(String role, int pageNum, int size);

    void memberRoleChange(Long memberId, String role);

    List<ReviewManageResDto> getReviews(int pageNum, int size);

    List<ReviewManageResDto> getReviewsBySort(String sort, int pageNum, int size);

}
