package com.green.sahwang.inspection.service.impl;

import com.green.sahwang.brand.repository.BrandRepository;
import com.green.sahwang.config.DateTimeUtils;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.inspection.dto.request.InspectionBrandReqDto;
import com.green.sahwang.inspection.dto.request.InspectionPassReqDto;
import com.green.sahwang.inspection.dto.request.InspectionRejectReqDto;
import com.green.sahwang.inspection.dto.response.*;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import com.green.sahwang.inspection.service.InspectionService;
import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.pendingsale.repository.PendingSaleRepository;
import com.green.sahwang.pendingsale.repository.UserSaleImageRepository;
import com.green.sahwang.repository.CategoryBrandRepository;
import com.green.sahwang.repository.CategoryRepository;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.service.ProductService;
import com.green.sahwang.service.impl.ProductServiceImpl;
import com.green.sahwang.verifiedsale.entity.RejectionReason;
import com.green.sahwang.verifiedsale.entity.SaleGrade;
import com.green.sahwang.verifiedsale.entity.VerifiedSale;
import com.green.sahwang.verifiedsale.repository.RejectionReasonRepository;
import com.green.sahwang.verifiedsale.repository.SaleGradeRepository;
import com.green.sahwang.verifiedsale.repository.VerifiedSaleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {
    private final PendingSaleRepository pendingSaleRepository;
    private final UserSaleImageRepository userSaleImageRepository;
    private final MemberRepository memberRepository;

//    private final CategoryRepository categoryRepository;
//    private final CategoryBrandRepository categoryBrandRepository;
//    private final BrandRepository brandRepository;
//    private final ProductRepository productRepository;
    private final VerifiedSaleRepository verifiedSaleRepository;
    private final SaleGradeRepository saleGradeRepository;
    private final RejectionReasonRepository rejectionReasonRepository;

    private final ProductServiceImpl productService;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Long getTotalCount() {
        return pendingSaleRepository.count();
    }

    @Override
    @Transactional
    public List<WaitingInspectionResDto> getWaitingInspections(int pageNum, int size, String sortType) {
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(Sort.Direction.ASC, sortType));
        Page<PendingSale> pendingSales = pendingSaleRepository.findAll(pageable);

        return pendingSales.stream()
                .map(pendingSale -> WaitingInspectionResDto.builder()
                        .seller(memberRepository.findById(pendingSale.getMember().getId())
                                .orElseThrow(() -> new BizException(ErrorCode.NO_MEMBER))
                                .getNickName())
                        .saleApplicationId(String.valueOf(pendingSale.getId()))
                        .brand(pendingSale.getBrandName())
                        .productName(pendingSale.getProductName())
                        .userContent(pendingSale.getProductDescription())
                        .expectedSellingPrice(pendingSale.getExceptedSellingPrice())
                        .shippedDate(DateTimeUtils.formatWithoutSecond(pendingSale.getCreatedDate().plusDays(3)))
                        .saleApplicationDate(DateTimeUtils.formatWithoutSecond(pendingSale.getCreatedDate()))
                        .category(pendingSale.getCategoryName())
                        .size(pendingSale.getProductSize())
                        .userSaleResImageList(
                                userSaleImageRepository.findAllByPendingSale(pendingSale).stream()
                                        .map(userSaleImage -> UserSaleResImage.builder()
                                                .pendingSaleId(pendingSale.getId())
                                                .path(userSaleImage.getPath())
                                                .name(userSaleImage.getFilename())
                                                .desc(userSaleImage.getFileDesc())
                                                .build())
                                        .collect(Collectors.toList())
                        )
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void inspectPassProduct(InspectionPassReqDto inspectionPassReqDto) {

        PendingSale pendingSale = pendingSaleRepository.findById(inspectionPassReqDto.getPendingSaleId())
                .orElseThrow(() -> new BizException(ErrorCode.NO_PENDINGSALE));

        VerifiedSale verifiedSale = VerifiedSale.builder()
                .pendingSale(pendingSale)
                .categoryName(inspectionPassReqDto.getInspectionCategoryReqDto().getCategoryName())
                .brandName(inspectionPassReqDto.getInspectionBrandReqDto().getBrandName())
                .productName(inspectionPassReqDto.getInspectionProductReqDto().getProductName())
                .productSize(inspectionPassReqDto.getInspectionProductReqDto().getProductSize())
                .verifiedSellingPrice(inspectionPassReqDto.getInspectionProductReqDto().getVerifiedSellingPrice())
                .saleGrade(saleGradeRepository.findById(inspectionPassReqDto.getGradeId()).orElseThrow(() -> new BizException(ErrorCode.NO_SALE_GRADE)))
                .inspectionResult(true)
                .inspectionDescription(inspectionPassReqDto.getInspectionContent())
                .posted(false)
                .createdDate(LocalDateTime.now())
                .build();

        verifiedSaleRepository.save(verifiedSale);

        pendingSale.setInspectionStatus(InspectionStatus.ACCEPTED);
        pendingSaleRepository.save(pendingSale);
    }

    @Override
    @Transactional
    public void inspectRejectProduct(InspectionRejectReqDto inspectionRejectReqDto) {
        PendingSale pendingSale = pendingSaleRepository.findById(inspectionRejectReqDto.getPendingSaleId())
                .orElseThrow(() -> new BizException(ErrorCode.NO_PENDINGSALE));

        RejectionReason rejectionReason = null;
        if (Objects.isNull(inspectionRejectReqDto.getRejectionReasonId())) {
            RejectionReason newReason = RejectionReason.builder()
                    .reason(inspectionRejectReqDto.getRejectionReason())
                    .build();
            rejectionReason = rejectionReasonRepository.save(newReason);
        } else {
            rejectionReason = rejectionReasonRepository.findById(inspectionRejectReqDto.getRejectionReasonId())
                    .orElseThrow(() -> new BizException(ErrorCode.NO_REJECTION_REASON));
        }

        VerifiedSale verifiedSale = VerifiedSale.builder()
                .pendingSale(pendingSale)
                .categoryName(inspectionRejectReqDto.getInspectionCategoryReqDto().getCategoryName())
                .brandName(inspectionRejectReqDto.getInspectionBrandReqDto().getBrandName())
                .productName(inspectionRejectReqDto.getInspectionProductReqDto().getProductName())
                .productSize(inspectionRejectReqDto.getInspectionProductReqDto().getProductSize())
                .verifiedSellingPrice(inspectionRejectReqDto.getInspectionProductReqDto().getVerifiedSellingPrice())
                .inspectionResult(inspectionRejectReqDto.isInspectionResult())
                .inspectionDescription(inspectionRejectReqDto.getInspectionContent())
                .posted(false)
                .createdDate(LocalDateTime.now())
                .rejectionReason(rejectionReason)
                .build();

        verifiedSaleRepository.save(verifiedSale);

        pendingSale.setInspectionStatus(InspectionStatus.REJECTED);
        pendingSale.setRejectedReason(rejectionReason.getReason());
        pendingSaleRepository.save(pendingSale);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InspectionGradeResDto> getProductGrade() {
        return saleGradeRepository.findAll().stream()
                .map(saleGrade -> InspectionGradeResDto.builder()
                        .gradeId(saleGrade.getId())
                        .gradeType(saleGrade.getGradeType())
                        .gradeDescription(saleGrade.getGradeDescription())
                        .build())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<InspectionRejectionReasonResDto> getFailReason() {
        return rejectionReasonRepository.findAll().stream()
                .map(rejectionReason -> InspectionRejectionReasonResDto.builder()
                        .rejectionReasonId(rejectionReason.getId())
                        .rejectionReason(rejectionReason.getReason())
                        .build())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResDto> searchInspectionProducts(Long brandId) {
        if (brandId == null) {
            return Collections.emptyList();
        }
        return productService.getProductResDtos(productRepository.findAllByBrandId(brandId));
    }
}
