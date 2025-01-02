package com.green.sahwang.inspection.controller;

import com.green.sahwang.brand.dto.response.BrandResDto;
import com.green.sahwang.brand.service.BrandService;
import com.green.sahwang.config.filepath.ImageFilePathConfig;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.inspection.dto.request.InspectionPassReqDto;
import com.green.sahwang.inspection.dto.request.InspectionRejectReqDto;
import com.green.sahwang.inspection.dto.response.InspectionGradeResDto;
import com.green.sahwang.inspection.dto.response.InspectionRejectionReasonResDto;
import com.green.sahwang.inspection.dto.response.WaitingInspectionResDto;
import com.green.sahwang.inspection.service.InspectionService;
import com.green.sahwang.service.ImageFileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/inspection")
@Slf4j
public class InspectionController {

    private final InspectionService inspectionService;
    private final BrandService brandService;
    private final ImageFileService imageFileService;
    private final Path imagePath;

    public InspectionController(InspectionService inspectionService, BrandService brandService, ImageFileService imageFileService, ImageFilePathConfig imageFilePathConfig) {
        this.inspectionService = inspectionService;
        this.brandService = brandService;
        this.imageFileService = imageFileService;
        this.imagePath = imageFilePathConfig.getImageFilePath();
    }

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

    @PostMapping(value = "/pass",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "검수 승인", description = "검수 승인 후 처리")
//    @PreAuthorize("hasAnyRole('ROLE_APPRAISER', 'ROLE_ADMIN')")
    public ResponseEntity<String> passInspection(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestPart(name = "userImageFiles", required = false) MultipartFile[] userImageFiles,
            @RequestPart(name = "passImageFiles") MultipartFile[] passImageFiles,
            @RequestPart(name = "inspectionPassReqDto") @Parameter(schema = @Schema(type = "string", format = "binary"))
            InspectionPassReqDto inspectionPassReqDto) {

//        validateFiles(userImageFiles);
//        validateFiles(passImageFiles);

        try {
            inspectionService.inspectPassProduct(inspectionPassReqDto);
//            imageFileService.saveUserImageFiles(userImageFiles, userImagePath, inspectionPassReqDto.getUserSaleReqImageDtos());
            imageFileService.savePassSaleImageFiles(passImageFiles, imagePath, inspectionPassReqDto.getPassSaleReqImageDtos());

        } catch (Exception e) {
            log.info("{}", e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Inspection Failed: " + e.getMessage());
        }
        return ResponseEntity.ok("appraiser success");
    }



    @PostMapping(value = "/reject",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "검수 반려", description = "검수 반려 처리")
//    @PreAuthorize("hasAnyRole('ROLE_APPRAISER', 'ROLE_ADMIN')")
    public ResponseEntity<?> rejectInspection(
            @RequestPart(name = "userImageFiles", required = false) MultipartFile[] userImageFiles,
            @RequestPart(name = "failImageFiles") MultipartFile[] failImageFiles,
            @RequestPart(name = "inspectionRejectReqDto") @Parameter(schema = @Schema(type = "string", format = "binary"))
            InspectionRejectReqDto inspectionRejectReqDto) {

        try {
            inspectionService.inspectRejectProduct(inspectionRejectReqDto);
//                imageFileService.saveUserImageFiles(userImageFiles, userImagePath, inspectionRejectReqDto.getUserSaleReqImageDtos());
            imageFileService.saveFailSaleImageFiles(failImageFiles, imagePath, inspectionRejectReqDto.getFailSaleReqImageDtos());

        } catch (Exception e) {
            log.info("{}", e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Inspection Failed: " + e.getMessage());
        }
        return ResponseEntity.ok("appraiser success");
    }

    @GetMapping("/search-products")
    @Operation(summary = "검수 시 필요한 제품 검색", description = "검수 페이지에서 제품 검색")
//    @PreAuthorize(("hasAnyRole('ROLE_APPRAISER', 'ROLE_ADMIN')"))
    public ResponseEntity<List<ProductResDto>> searchInspectionProducts(@RequestParam Long brandId) {
        return ResponseEntity.ok(inspectionService.searchInspectionProducts(brandId));
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
    private void validateFiles(MultipartFile[] files) {
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                throw new BizException(ErrorCode.NO_FILE);
            }
//            if (file.getSize() > 10 * 1024 * 1024) {
//                throw new IllegalArgumentException("파일 사이즈가 10MB를 초과했습니다.")
//            }
//            if (!isAllowedFileType(file)) {
//                throw new BizException(ErrorCode.NO_IMAGE_FILE);
//            }
        }
    }

//    private boolean isAllowedFileType(MultipartFile file) {
//        String contentType = file.getContentType();
//        return contentType != null &&
//                (contentType.equals("image/jpeg") || contentType.equals("image/png"));
//    }

}
