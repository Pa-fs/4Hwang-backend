package com.green.sahwang.brand.service;

import com.green.sahwang.brand.dto.response.BrandResDto;

import java.util.List;

public interface BrandService {

    List<BrandResDto> searchBrands(String keyword);

}
