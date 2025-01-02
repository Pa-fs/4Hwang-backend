package com.green.sahwang.adminpage.controller;

import com.green.sahwang.adminpage.dto.req.MemberRoleReqDto;
import com.green.sahwang.adminpage.dto.MemberManageDto;
import com.green.sahwang.adminpage.dto.res.*;
import com.green.sahwang.adminpage.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/member/management")
    public ResponseEntity<MemberManageResDto> getMembers(@RequestParam(value = "role", required = false) String role,
                                                         @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                         @RequestParam(name = "size", defaultValue = "20", required = false) int size){
        if (role == null || role.equalsIgnoreCase("null")) {
            MemberManageResDto memberManageResDto = adminService.getMembers(pageNum, size);
            return ResponseEntity.ok(memberManageResDto);
        }
        else {
            MemberManageResDto memberManageResDto = adminService.getMembersByRole(role, pageNum, size);
            return ResponseEntity.ok(memberManageResDto);
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
    public ResponseEntity<ReviewManageResDto> getReviews(@RequestParam(value = "sort", required = false) String sort,
                                                            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "20", required = false) int size){
        if (sort == null || sort.equalsIgnoreCase("null")){
            ReviewManageResDto reviewManageResDto = adminService.getReviews(pageNum, size);
            return ResponseEntity.ok(reviewManageResDto);
        }else {
            ReviewManageResDto reviewManageResDto = adminService.getReviewsBySort(sort, pageNum, size);
            return ResponseEntity.ok(reviewManageResDto);
        }
    }

    @GetMapping("/review/management/search")
    public ResponseEntity<ReviewManageResDto> getSearchReviews(@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
                                                                     @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                                     @RequestParam(name = "size", defaultValue = "20", required = false) int size){
        ReviewManageResDto reviewManageResDto = adminService.getReviewBySearch(searchKeyword, pageNum, size);
        return ResponseEntity.ok(reviewManageResDto);
    }

    @DeleteMapping("/review/management/delete")
    public ResponseEntity<String> deleteReview(@RequestParam(value = "reviewId") Long reviewId){
        adminService.deleteReview(reviewId);
        return ResponseEntity.ok("리뷰가 삭제되었습니다");
    }

    @Operation(summary = "null 일 때만 가능", description = "기본 : null")
    @GetMapping("/product/management/usedProduct")
    public ResponseEntity<ProductManageResDto> getProducts(@RequestParam(value = "status", required = false) String status,
                                                           @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                           @RequestParam(name = "size", defaultValue = "20", required = false) int size){
        if (status == null || status.equalsIgnoreCase("null")){
            ProductManageResDto productManageResDto = adminService.getProducts(pageNum, size);
            return ResponseEntity.ok(productManageResDto);
        }
        else {
            ProductManageResDto productManageResDto = adminService.getProductsByStatus(status, pageNum, size);
            return ResponseEntity.ok(productManageResDto);
        }
    }

    @Operation(summary = "null 일 때만 가능", description = "기본 : null")
    @GetMapping("/product/management/category")
    public ResponseEntity<CategoryManageResDto> getCategories(@RequestParam(value = "status", required = false) String status,
                                                              @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                              @RequestParam(name = "size", defaultValue = "20", required = false) int size){
        if (status == null || status.equalsIgnoreCase("null")){
            CategoryManageResDto categoryManageResDto = adminService.getCategories(pageNum, size);
            return ResponseEntity.ok(categoryManageResDto);
        }
        else {
            CategoryManageResDto categoryManageResDto = adminService.getCategoriesByStatus(status, pageNum, size);
            return ResponseEntity.ok(categoryManageResDto);
        }
    }

    @Operation(summary = "이건 그냥 못하겠음 -> 일단 하긴했는데...", description = "null일 때만 가능")
    @GetMapping("/order/management")
    public ResponseEntity<Page<OrderManageResDto>> getOrders(@RequestParam(value = "status", required = false) String status,
                                                            @RequestParam(name = "pageNum", defaultValue = "0", required = false) int pageNum,
                                                            @RequestParam(name = "size", defaultValue = "20", required = false) int size) {
        if (status == null || status.equalsIgnoreCase("null")) {
            Page<OrderManageResDto> orderManageResDtoPage = adminService.getOrders(pageNum, size);
            return ResponseEntity.ok(orderManageResDtoPage);
        } else {
            OrderManageResDto orderManageResDto = adminService.getOrdersByStatus(status, pageNum, size);
            return null;
        }
    }

    @GetMapping("/dashboard/order")
    public ResponseEntity<?> getDashOrders(){

        return null;
    }

    @GetMapping("/dashboard/pending")
    public ResponseEntity<?> getDashPending(){

        return null;
    }

    @Operation(summary = "대쉬보드 회원가입 수", description = "오늘 회원가입한 멤버 수")
    @GetMapping("/dashboard/member/join")
    public ResponseEntity<DashMemberJoinResDto> getDashJoinMembers(){
        DashMemberJoinResDto dashMemberJoinResDto = adminService.getDashJoinMembers();

        return ResponseEntity.ok(dashMemberJoinResDto);
    }

    @Operation(summary = "대쉬보드 로그인 수", description = "오늘 로그인 한 멤버 수")
    @GetMapping("/dashboard/member/logIn")
    public ResponseEntity<DashMemberLogInResDto> getDashLogInMembers(){
        DashMemberLogInResDto dashMemberLogInResDto = adminService.getDashLogInMembers();

        return ResponseEntity.ok(dashMemberLogInResDto);
    }

    @GetMapping("/dashboard/review")
    public ResponseEntity<?> getDashReviews(){

        return null;
    }

    @Operation(summary = "통계 매출수익", description = "판매금액의 5%를 수수료 -> 매출수익")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/statistics/revenue")
    public ResponseEntity<RevenueResWithTotalPriceDto> getRevenues(@AuthenticationPrincipal UserDetails userDetails,
                                                           @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                           @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        if (startDate == null) {
            startDate = LocalDate.now().minusMonths(1);
        }
        if (endDate == null) {
            endDate = LocalDate.now();
        }
        return ResponseEntity.ok(adminService.getRevenues(userDetails.getUsername(), startDate, endDate));
    }

}
