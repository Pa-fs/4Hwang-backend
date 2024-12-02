package com.green.sahwang.service.impl;

import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.ReviewImage;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.mypage.dto.req.ReviewImageReqDto;
import com.green.sahwang.repository.ProductImageRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.ReviewImageRepository;
import com.green.sahwang.repository.ReviewRepository;
import com.green.sahwang.service.ImageFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;


@Service
@RequiredArgsConstructor
@Slf4j
public class ImageFileServiceImpl implements ImageFileService {

    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewImageRepository reviewImageRepository;

    public void saveFile(MultipartFile file, Path imagePath, ImageFileReqDto imageFileReqDto) {
        try {
            String relativePath = "images/file/";
            String fileName = file.getOriginalFilename();
            String filePath = relativePath + File.separator + fileName;

            String absoluteFilePath = imagePath.toString() + File.separator + fileName;

            File dest = new File(absoluteFilePath);
            file.transferTo(dest);

            Product product = productRepository.findById(imageFileReqDto.getProductId())
                    .orElseThrow(() -> new ProductDomainException("해당 상품이 존재하지 않습니다"));


            ProductImage productImage = ProductImage.builder()
                    .product(product)
                    .path(filePath)
                    .filename(imageFileReqDto.getName())
                    .fileDesc(imageFileReqDto.getDesc())
                    .build();
            productImageRepository.save(productImage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveReviewImage(MultipartFile file, Path imagePath, ReviewImageReqDto reviewImageReqDto){
        try {
            String relativePath = "images/file/";
            String fileName = file.getOriginalFilename();
            String filePath = relativePath + File.separator + fileName;

            String absoluteFilePath = imagePath.toString() + File.separator + fileName;

            File dest = new File(absoluteFilePath);
            file.transferTo(dest);

            Review review = reviewRepository.findById(reviewImageReqDto.getReviewId()).orElseThrow();

            ReviewImage reviewImage = ReviewImage.builder()
                    .review(review)
                    .path(filePath)
                    .filename(reviewImageReqDto.getName())
                    .fileDesc(reviewImageReqDto.getDesc())
                    .build();
            reviewImageRepository.save(reviewImage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
