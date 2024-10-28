package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.DetailChartResDto;
import com.green.sahwang.detail.dto.response.DetailImagesResDto;

import java.util.List;

public interface ProductDetailService {

    List<DetailChartResDto> getSaleProducts(Long productId);
    DetailImagesResDto getProductImages(Long productId);

}
