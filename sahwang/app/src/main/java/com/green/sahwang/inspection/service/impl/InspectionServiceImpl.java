package com.green.sahwang.inspection.service.impl;

import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.inspection.dto.request.InspectionPassReqDto;
import com.green.sahwang.inspection.dto.response.InspectionPassResDto;
import com.green.sahwang.inspection.dto.response.UserSaleResImage;
import com.green.sahwang.inspection.dto.response.WaitingInspectionResDto;
import com.green.sahwang.inspection.service.InspectionService;
import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.pendingsale.repository.PendingSaleRepository;
import com.green.sahwang.pendingsale.repository.UserSaleImageRepository;
import com.green.sahwang.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {
    private final PendingSaleRepository pendingSaleRepository;
    private final UserSaleImageRepository userSaleImageRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public List<WaitingInspectionResDto> getWaitingInspections(int pageNum, int size, String sortType) {
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(Sort.Direction.DESC, sortType));
        Page<PendingSale> pendingSales = pendingSaleRepository.findAll(pageable);

        return pendingSales.stream()
                .map(pendingSale -> WaitingInspectionResDto.builder()
                        .seller(memberRepository.findById(pendingSale.getMember().getId())
                                .orElseThrow(() -> new BizException(ErrorCode.NO_MEMBER))
                                .getName())
                        .saleApplicationId(String.valueOf(pendingSale.getId()))
                        .brand(pendingSale.getBrandName())
                        .productName(pendingSale.getProductName())
                        .userContent(pendingSale.getProductDescription())
                        .expectedSellingPrice(pendingSale.getExceptedSellingPrice())
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
    public InspectionPassResDto inspectProduct(InspectionPassReqDto inspectionPassReqDto) {
        return null;
    }
}
