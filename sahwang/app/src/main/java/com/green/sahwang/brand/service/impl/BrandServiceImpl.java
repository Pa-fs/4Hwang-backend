package com.green.sahwang.brand.service.impl;

import com.green.sahwang.brand.dto.response.BrandResDto;
import com.green.sahwang.brand.entity.Brand;
import com.green.sahwang.brand.repository.BrandRepository;
import com.green.sahwang.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    @Override
    @Transactional(readOnly = true)
    public List<BrandResDto> searchBrands(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return Collections.emptyList();
        }
        return brandRepository.findByKeyword(keyword).stream()
                .map(Brand -> BrandResDto.builder()
                        .brandId(Brand.getId())
                        .brandName(Brand.getName())
                        .build())
                .toList();
    }
}
