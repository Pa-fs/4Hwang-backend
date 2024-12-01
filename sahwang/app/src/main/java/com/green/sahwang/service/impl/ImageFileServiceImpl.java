package com.green.sahwang.service.impl;

import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.pendingsale.dto.request.UserSaleReqImage;
import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.pendingsale.entity.UserSaleImage;
import com.green.sahwang.pendingsale.repository.PendingSaleRepository;
import com.green.sahwang.pendingsale.repository.UserSaleImageRepository;
import com.green.sahwang.repository.ProductImageRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.service.ImageFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ImageFileServiceImpl implements ImageFileService {

    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;
    private final PendingSaleRepository pendingSaleRepository;
    private final UserSaleImageRepository userSaleImageRepository;


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

    @Override
    public void saveFiles(MultipartFile[] files, Path imagePath, List<UserSaleReqImage> userSaleReqImages) {
        try {
            String relativePath = "images/file/user/";
            for (MultipartFile file : files) {
                String filename = file.getOriginalFilename();
                String filePath = relativePath + File.separator + filename;

                String absoluteFilePath = imagePath.toString() + File.separator + filename;

                File dest = new File(absoluteFilePath);
                file.transferTo(dest);

                for (UserSaleReqImage userSaleReqImage : userSaleReqImages) {
                    PendingSale pendingSale = pendingSaleRepository.findById(userSaleReqImage.getPendingSaleId())
                            .orElseThrow(() -> new BizException(ErrorCode.NO_PRODUCT));


                    UserSaleImage userSaleImage = UserSaleImage.builder()
                            .path(filePath)
                            .pendingSale(pendingSale)
                            .filename(userSaleReqImage.getName())
                            .fileDesc(userSaleReqImage.getDesc())
                            .build();

                    userSaleImageRepository.save(userSaleImage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
