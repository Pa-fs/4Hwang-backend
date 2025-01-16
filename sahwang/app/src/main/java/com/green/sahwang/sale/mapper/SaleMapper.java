package com.green.sahwang.sale.mapper;

import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.mypage.dto.res.SaleListResDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface SaleMapper {
    List<SaleListResDto> findSaleList(@Param("memberId") Long memberId, Pageable pageable);

    // 해당 saleId에 대한 user 이미지 리스트 조회
    List<ImageResDto> findUserImages(Long saleId);

    // 해당 verifiedSaleId에 대한 검증된 이미지 리스트 조회
    List<ImageResDto> findVerifiedImages(Long verifiedSaleId);

    String findProductImageById(@Param("productId") Long productId);

    String findSellerById(@Param("memberId") Long memberId);

    int findSaleListTotalCount(@Param("memberId") Long memberId);

}
