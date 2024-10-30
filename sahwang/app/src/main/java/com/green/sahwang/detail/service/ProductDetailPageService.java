package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.DetailChartResDto;
import com.green.sahwang.detail.dto.response.DetailImagesResDto;
import com.green.sahwang.detail.dto.response.DetailReviewResDto;

import java.util.List;

public interface ProductDetailPageService {

    List<DetailChartResDto> getSaleProducts(Long productId);
    DetailImagesResDto getProductImages(Long productId);
    DetailReviewResDto getDetailReviewInfo(Long productId);

}
