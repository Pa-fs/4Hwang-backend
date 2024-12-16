package com.green.sahwang.adminpage.controller;

import com.green.sahwang.adminpage.dto.req.MemberRoleReqDto;
import com.green.sahwang.adminpage.dto.res.MemberManageResDto;
import com.green.sahwang.adminpage.dto.res.ReviewManageResDto;
import com.green.sahwang.adminpage.service.AdminService;
import com.green.sahwang.entity.enumtype.MemberRole;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<List<MemberManageResDto>> getMembers(@RequestParam(value = "role", required = false) String role,
                                                               @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                               @RequestParam(name = "size", defaultValue = "20", required = false) int size){
        if (role == null) {
            List<MemberManageResDto> memberManageResDtoList = adminService.getMembers(pageNum, size);
            return ResponseEntity.ok(memberManageResDtoList);
        }
        else {
            List<MemberManageResDto> memberManageResDtoList = adminService.getMembersByRole(role, pageNum, size);
            return ResponseEntity.ok(memberManageResDtoList);
        }
    }

    @Operation(summary = "멤버 권한수정", description = "권한수정하려는 member id / role은 대소문자 구분필요X")
    @PostMapping("/member/management/roleChange")
    public ResponseEntity<String> memberRoleChange( @RequestBody MemberRoleReqDto memberRoleReqDto){
        adminService.memberRoleChange(memberRoleReqDto.getMemberId(), memberRoleReqDto.getRole());
        return ResponseEntity.ok("사용자의 권한이 수정되었습니다");
    }

    @Operation(summary = "리뷰 관리", description = "sort 값 = 카테고리 : category / 상품명 : productName / 별점 높은순 : starDesc / 별점 낮은순 : starAsc / 기본 : null")
    @GetMapping("/review/management")
    public ResponseEntity<Page<ReviewManageResDto>> getReviews(@RequestParam(value = "sort", required = false) String sort,
                                                               @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                               @RequestParam(name = "size", defaultValue = "20", required = false) int size){
        if (sort == null){
            Page<ReviewManageResDto> reviewManageResDtoPage = adminService.getReviews(pageNum, size);
            return ResponseEntity.ok(reviewManageResDtoPage);
        }else {
            Page<ReviewManageResDto> reviewManageResDtoList = adminService.getReviewsBySort(sort, pageNum, size);
            return ResponseEntity.ok(reviewManageResDtoList);
        }
    }

    @GetMapping("/review/management/search")
    public ResponseEntity<List<ReviewManageResDto>> getSearchReviews(@RequestParam(value = "productName", required = false) String productName){

        return ResponseEntity.ok(null);
    }

}
