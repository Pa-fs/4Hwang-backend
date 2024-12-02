package com.green.sahwang.service;

import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.mypage.dto.req.ReviewImageReqDto;
import com.green.sahwang.pendingsale.dto.request.UserSaleReqImage;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface ImageFileService {

    void saveFile(MultipartFile file, Path imagePath, ImageFileReqDto imageFileReqDto);

    void saveReviewImage(MultipartFile file, Path imagePath, ReviewImageReqDto reviewImageReqDto);
  
    void saveFiles(MultipartFile[] files, Path imagePath, List<UserSaleReqImage> userSaleReqImages);
}
