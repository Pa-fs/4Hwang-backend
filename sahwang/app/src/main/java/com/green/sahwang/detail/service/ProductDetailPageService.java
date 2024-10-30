package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ProductDetailPageService {

    List<DetailChartResDto> getSaleProducts(Long productId);
    DetailImagesResDto getProductImages(Long productId);
    DetailReviewResDto getDetailReviewInfo(Long productId);
    List<ReviewResDto> getReviewPages(Long productId, int pageNum, int size);
    List<FavoriteCheckedResDto> getChecked(Long productId, UserDetails userDetails);

}
