package com.green.sahwang.service;

import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.inspection.dto.request.FailSaleReqImageDto;
import com.green.sahwang.inspection.dto.request.PassSaleReqImageDto;
import com.green.sahwang.mypage.dto.req.ReviewImageReqDto;
import com.green.sahwang.pendingsale.dto.request.UserSaleReqImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface ImageFileService {

    void saveFile(MultipartFile file, Path imagePath, ImageFileReqDto imageFileReqDto);

    void saveReviewImage(MultipartFile file, Path imagePath, ReviewImageReqDto reviewImageReqDto);
  
    void saveUserImageFiles(MultipartFile[] files, Path imagePath, List<UserSaleReqImageDto> userSaleReqImageDtos);

    void savePassSaleImageFiles(MultipartFile[] files, Path imagePath, List<PassSaleReqImageDto> passSaleReqImageDtos);

    void saveFailSaleImageFiles(MultipartFile[] files, Path imagePath, List<FailSaleReqImageDto> failSaleReqImageDtos);
}
