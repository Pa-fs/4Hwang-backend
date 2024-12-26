package com.green.sahwang.verifiedsale.service.impl;

import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.sale.mapper.SaleMapper;
import com.green.sahwang.verifiedsale.dto.response.SaleAcceptedListResDto;
import com.green.sahwang.verifiedsale.dto.response.SaleRejectionListResDto;
import com.green.sahwang.verifiedsale.mapper.VerifiedSaleAcceptedMapper;
import com.green.sahwang.verifiedsale.mapper.VerifiedSaleRejectionMapper;
import com.green.sahwang.verifiedsale.service.VerifiedSaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VerifiedSaleServiceImpl implements VerifiedSaleService {

    private final SaleMapper saleMapper;
    private final VerifiedSaleAcceptedMapper verifiedSaleAcceptedMapper;
    private final VerifiedSaleRejectionMapper verifiedSaleRejectionMapper;

    private final MemberRepository memberRepository;

    @Override
    public List<SaleAcceptedListResDto> getVerifiedSaleAcceptedList(String email, int pageNum, int size, String sortType) {
        checkRole(email);

        // 추후 정렬 기준 추가
        Pageable pageable = PageRequest.of(pageNum, size);

        List<SaleAcceptedListResDto> verifiedSaleAcceptedList = verifiedSaleAcceptedMapper.findVerifiedSaleAcceptedList(pageable);

        for (SaleAcceptedListResDto saleAcceptedListResDto : verifiedSaleAcceptedList) {
            String seller = saleMapper.findSellerById(saleAcceptedListResDto.getMemberId());
            String representativeImage = saleMapper.findProductImageById(saleAcceptedListResDto.getProductId());
            List<ImageResDto> userImages = saleMapper.findUserImages(saleAcceptedListResDto.getPendingSaleId());
            List<ImageResDto> verifiedImages = saleMapper.findVerifiedImages(saleAcceptedListResDto.getVerifiedSaleId());

            saleAcceptedListResDto.setUserImages(userImages);
            saleAcceptedListResDto.setVerifiedImages(verifiedImages);
            saleAcceptedListResDto.setSeller(seller);
            saleAcceptedListResDto.setRepresentativeImage(representativeImage);
        }

        return verifiedSaleAcceptedList;
    }

    @Override
    public List<SaleRejectionListResDto> getVerifiedSaleRejectionList(String email, int pageNum, int size, String sortType) {
        checkRole(email);

        // 추후 정렬 기준 추가
        Pageable pageable = PageRequest.of(pageNum, size);

        List<SaleRejectionListResDto> verifiedSaleRejectionList = verifiedSaleRejectionMapper.findVerifiedSaleRejectionList(pageable);

        for (SaleRejectionListResDto saleRejectionListResDto : verifiedSaleRejectionList) {
            String seller = saleMapper.findSellerById(saleRejectionListResDto.getMemberId());
            String representativeImage = saleMapper.findProductImageById(saleRejectionListResDto.getProductId());
            List<ImageResDto> userImages = saleMapper.findUserImages(saleRejectionListResDto.getPendingSaleId());
            List<ImageResDto> verifiedImages = saleMapper.findVerifiedImages(saleRejectionListResDto.getVerifiedSaleId());

            saleRejectionListResDto.setUserImages(userImages);
            saleRejectionListResDto.setVerifiedImages(verifiedImages);
            saleRejectionListResDto.setSeller(seller);
            saleRejectionListResDto.setRepresentativeImage(representativeImage);
        }

        return verifiedSaleRejectionList;
    }

    private void checkRole(String email) {
        Member member = memberRepository.findByEmail(email);
        if(!(member.getRole().equals(MemberRole.ADMIN) || member.getRole().equals(MemberRole.APPRAISER))) {
            throw new BizException(ErrorCode.NO_USER_ROLE);
        }
    }
}
