package com.green.sahwang.usedproduct.service.impl;

import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.usedproduct.dto.response.UsedProductResDto;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.entity.enumtype.UsedProductType;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import com.green.sahwang.usedproduct.service.UsedProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsedProductServiceImpl implements UsedProductService {

    private final UsedProductRepository usedProductRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UsedProductResDto> getUsedProducts(Long productId, int pageNum, int size, String sortType) {
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(Sort.Direction.DESC, sortType));
        Page<UsedProduct> usedProducts = usedProductRepository.findUsedProductsByProductId(productId, UsedProductType.USER_ACCEPT ,pageable);
        return usedProducts.stream()
                .map(up -> UsedProductResDto.builder()
                        .productId(productId)
                        .sellingPrice(up.getVerifiedSale().getPendingSale().getExceptedSellingPrice())
                        .productSize(up.getVerifiedSale().getProductSize())
                        .usedProductId(up.getId())
                        .productName(up.getVerifiedSale().getProductName())
                        .brandName(up.getVerifiedSale().getBrandName())
                        .nickName(up.getVerifiedSale().getPendingSale().getMember().getNickName())
                        .verifiedSaleGradeType(up.getVerifiedSale().getSaleGrade().getGradeType().toString())
                        .userSaleImages(
                                up.getVerifiedSale().getPendingSale().getUserSaleImages()
                                        .stream().map(image -> ImageResDto.builder()
                                                .path(image.getPath())
                                                .filename(image.getFilename())
                                                .fileDesc(image.getFileDesc())
                                                .build())
                                        .toList())
                        .build())
                .toList();
    }
}
