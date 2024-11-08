package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.*;
import com.green.sahwang.dto.request.ImageFileReqDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductDetailPageService {

    List<DetailChartResDto> getSaleProducts(Long productId, int size);

    DetailImagesResDto getProductImages(Long productId);

//    DetailReviewResDto getDetailReviewInfo(Long productId);

    List<DetailProductInfoResDto> getDetailProductInfo(Long productId);

    DetailReviewInfoResDto getDetailReviewInfo(Long productId);

    void saveDetailMainImage(MultipartFile file, ImageFileReqDto imageFileReqDto);

    DetailMainImageResDto getDetailMainPageImage(Long productId);

    List<ReviewResDto> getReviewPages(Long productId, int pageNum, int size);

    List<ReviewImageResDto> getReviewImages(Long productId);

    List<FavoriteCheckedResDto> getChecked(Long productId, UserDetails userDetails);

    FavoriteClickResDto clickFavorite(Long reviewId, UserDetails userDetails);

    FavoriteClickResDto cancelFavorite(Long reviewId, UserDetails userDetails);

}
