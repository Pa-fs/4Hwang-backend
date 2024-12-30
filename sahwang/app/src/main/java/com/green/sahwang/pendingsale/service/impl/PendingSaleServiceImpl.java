package com.green.sahwang.pendingsale.service.impl;

import com.green.sahwang.entity.Member;
import com.green.sahwang.inspection.enumtype.InspectionStatus;
import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.pendingsale.repository.PendingSaleRepository;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.pendingsale.dto.request.PendingSaleCreateReqDto;
import com.green.sahwang.pendingsale.service.PendingSaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PendingSaleServiceImpl implements PendingSaleService {

    private final PendingSaleRepository pendingSaleRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void createPendingSale(PendingSaleCreateReqDto pendingSaleCreateReqDto, String email) {
        Member member = memberRepository.findByEmail(email);
        member.setBankName(pendingSaleCreateReqDto.getBankName());
        member.setAccount(pendingSaleCreateReqDto.getAccountNumber());
        memberRepository.save(member);

        PendingSale pendingSale = PendingSale.builder()
                .productDescription(pendingSaleCreateReqDto.getProductContent())
                .productSize(pendingSaleCreateReqDto.getProductSize())
                .exceptedSellingPrice(pendingSaleCreateReqDto.getExpectedSellingPrice())
                .productName(pendingSaleCreateReqDto.getProductName())
                .brandName(pendingSaleCreateReqDto.getBrandName())
                .categoryName(pendingSaleCreateReqDto.getCategoryName())
                .createdDate(LocalDateTime.now())
                .usedOrNot(pendingSaleCreateReqDto.isUsedOrNot())
                .inspectionStatus(InspectionStatus.WAITING)
                .member(member)
                .build();

        PendingSale savedPendingSale = pendingSaleRepository.save(pendingSale);
        pendingSaleCreateReqDto.getUserSaleReqImageDtos().forEach(userSaleReqImage ->
                userSaleReqImage.setPendingSaleId(savedPendingSale.getId()));
    }

    @Override
    public String getPendingSaleNickname(String email) {
        Member member = memberRepository.findByEmail(email);
        return member.getNickName();
    }
}
