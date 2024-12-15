package com.green.sahwang.adminpage.controller;

import com.green.sahwang.adminpage.dto.req.MemberRoleReqDto;
import com.green.sahwang.adminpage.dto.res.MemberManageResDto;
import com.green.sahwang.adminpage.dto.res.ReviewManageResDto;
import com.green.sahwang.adminpage.service.AdminService;
import com.green.sahwang.entity.enumtype.MemberRole;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/member/management")
    public ResponseEntity<List<MemberManageResDto>> getMembers(@RequestParam(value = "role", required = false) String role){
        if (role == null) {
            List<MemberManageResDto> memberManageResDtoList = adminService.getMembers();
            return ResponseEntity.ok(memberManageResDtoList);
        }
        else {
            List<MemberManageResDto> memberManageResDtoList = adminService.getMembersByRole(MemberRole.valueOf(role));
            return ResponseEntity.ok(memberManageResDtoList);
        }
    }

    @Operation(summary = "멤버 권한수정", description = "권한수정하려는 member id / role은 대소문자 구분필요X")
    @PostMapping("/member/management/roleChange")
    public ResponseEntity<String> memberRoleChange( @RequestBody MemberRoleReqDto memberRoleReqDto){
        adminService.memberRoleChange(memberRoleReqDto.getMemberId(), memberRoleReqDto.getRole());
        return ResponseEntity.ok("사용자의 권한이 수정되었습니다");
    }

    @GetMapping("/review/management")
    public ResponseEntity<List<ReviewManageResDto>> getReviews(@RequestParam(value = "sort", required = false) String sort){

        return ResponseEntity.ok(null);
    }

}
