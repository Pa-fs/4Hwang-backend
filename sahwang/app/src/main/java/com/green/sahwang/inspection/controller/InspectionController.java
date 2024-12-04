package com.green.sahwang.inspection.controller;

import com.green.sahwang.brand.dto.response.BrandResDto;
import com.green.sahwang.brand.service.BrandService;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.inspection.dto.request.InspectionPassReqDto;
import com.green.sahwang.inspection.dto.request.InspectionRejectReqDto;
import com.green.sahwang.inspection.dto.response.InspectionGradeResDto;
import com.green.sahwang.inspection.dto.response.InspectionRejectionReasonResDto;
import com.green.sahwang.inspection.dto.response.WaitingInspectionResDto;
import com.green.sahwang.inspection.service.InspectionService;
import com.green.sahwang.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inspection")
@RequiredArgsConstructor
public class InspectionController {

    private final InspectionService inspectionService;
    private final ProductService productService;
    private final BrandService brandService;

    @GetMapping("/pending-sale/total-count")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "검수대기 리스트 총 개수", description = "페이지네이션을 위한 총 개수 주기")
    public ResponseEntity<Long> getWaitingInspectionsCount() {
        Long totalCount = inspectionService.getTotalCount();
        return ResponseEntity.ok(totalCount);
    }

    @GetMapping("/list")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "검수대기 리스트", description = "검수자만 조회 가능, 기본값 5개씩 데이터 출력, 기본 정렬: 데이터 생성날짜 기준 오래된 순")
//    @PreAuthorize(("hasAnyRole('ROLE_APPRAISER', 'ROLE_ADMIN')"))
    public ResponseEntity<List<WaitingInspectionResDto>> getWaitingInspections(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "sortType", defaultValue = "createdDate", required = false) String sortType) {
        return ResponseEntity.ok(inspectionService.getWaitingInspections(pageNum, size, sortType));
    }

    @PostMapping("/pass")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "검수 승인", description = "검수 승인 후 처리")
//    @PreAuthorize("hasAnyRole('ROLE_APPRAISER', 'ROLE_ADMIN')")
    public ResponseEntity<?> passInspection(@RequestBody InspectionPassReqDto inspectionPassReqDto) {
        if (inspectionPassReqDto.isInspectionResult()) {
            inspectionService.inspectPassProduct(inspectionPassReqDto);
        } else {
            return ResponseEntity.badRequest().body("Invalid inspection");
        }
        return ResponseEntity.ok("appraiser success");
    }

    @PostMapping("/reject")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "검수 반려", description = "검수 반려 처리")
//    @PreAuthorize("hasAnyRole('ROLE_APPRAISER', 'ROLE_ADMIN')")
    public ResponseEntity<?> rejectInspection(@RequestBody InspectionRejectReqDto inspectionRejectReqDto) {
        if (!inspectionRejectReqDto.isInspectionResult()) {
            inspectionService.inspectRejectProduct(inspectionRejectReqDto);
        } else {
            return ResponseEntity.badRequest().body("Invalid inspection");
        }
        return ResponseEntity.ok("appraiser success");
    }

    @GetMapping("/search-products")
    @Operation(summary = "검수 시 필요한 제품 검색", description = "검수 페이지에서 제품 검색")
//    @PreAuthorize(("hasAnyRole('ROLE_APPRAISER', 'ROLE_ADMIN')"))
    public ResponseEntity<List<ProductResDto>> searchInspectionProducts(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.searchProducts(keyword));
    }

    @GetMapping("/search-brands")
    @Operation(summary = "검수 시 필요한 브랜드 검색", description = "검수 페이지에서 브랜드 검색")
//    @PreAuthorize(("hasAnyRole('ROLE_APPRAISER', 'ROLE_ADMIN')"))
    public ResponseEntity<List<BrandResDto>> searchInspectionBrands(@RequestParam String keyword) {
        return ResponseEntity.ok(brandService.searchBrands(keyword));
    }

    @GetMapping("/pass/grade")
    @Operation(summary = "검수 합격 시 등급 목록", description = "검수 페이지에서 합격 시 등급 목록")
    public ResponseEntity<List<InspectionGradeResDto>> getProductGrade() {
        return ResponseEntity.ok(inspectionService.getProductGrade());
    }

    @GetMapping("/fail/reason")
    @Operation(summary = "검수 실패 시 반려사유 목록", description = "검수 페이지에서 반려사유 목록")
    public ResponseEntity<List<InspectionRejectionReasonResDto>> getFailReason() {
        return ResponseEntity.ok(inspectionService.getFailReason());
    }

}
