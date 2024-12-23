package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.*;
import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.usedproduct.dto.VerifiedAndUserSaleImageResDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductDetailPageService {

    List<DetailChartResDto> getSaleProducts(Long productId);

    List<VerifiedAndUserSaleImageResDto> getProductImages(Long productId);

//    DetailReviewResDto getDetailReviewInfo(Long productId);

    DetailProductInfoResDto getDetailProductInfo(Long usedProductId);

    DetailReviewInfoResDto getDetailReviewInfo(Long productId);

    void saveDetailMainImage(MultipartFile file, ImageFileReqDto imageFileReqDto);

    DetailMainImageResDto getDetailMainPageImage(Long usedProductId);

    List<ReviewResDto> getReviewPages(Long usedProductId, int pageNum, int size);

    List<ReviewImageResDto> getReviewImages(Long usedProductId);

    List<FavoriteCheckedResDto> getChecked(Long usedProductId, UserDetails userDetails, int pageNum, int size);

//    FavoriteClickResDto clickFavorite(Long reviewId, UserDetails userDetails);
//
//    FavoriteClickResDto cancelFavorite(Long reviewId, UserDetails userDetails);

    FavoriteClickResDto clickFavorite(UserDetails userDetails, Long reviewId);

    List<DetailChartResDto> getChartOneMonth(Long usedProductId);

    List<DetailChartResDto> getChartSixMonth(Long usedProductId);

}
