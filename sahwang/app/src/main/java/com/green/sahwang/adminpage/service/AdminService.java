package com.green.sahwang.adminpage.service;

import com.green.sahwang.adminpage.dto.res.MemberManageResDto;
import com.green.sahwang.entity.enumtype.MemberRole;

import java.util.List;

public interface AdminService {

    List<MemberManageResDto> getMembers();

    List<MemberManageResDto> getMembersByRole(MemberRole role);

    void memberRoleChange(Long memberId, String role);

}
