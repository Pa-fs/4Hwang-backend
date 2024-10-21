package com.green.sahwang.service.impl;

import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.repository.ProductImageRepository;
import com.green.sahwang.repository.ProductRepository;
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


}
