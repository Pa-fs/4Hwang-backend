package com.green.sahwang.service.impl;

import com.green.sahwang.brand.entity.Brand;
import com.green.sahwang.brand.mapper.BrandMapper;
import com.green.sahwang.config.DateTimeUtils;
import com.green.sahwang.dto.response.*;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.mainpage.dto.BestProductResDto;
import com.green.sahwang.mainpage.dto.NewUsedProductResDto;
import com.green.sahwang.pendingsale.entity.UserSaleImage;
import com.green.sahwang.product.mapper.ProductMapper;
import com.green.sahwang.repository.ProductImageRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.service.ProductService;
import com.green.sahwang.service.ReviewService;
import com.green.sahwang.usedproduct.dto.response.GeneralUsedProductResDto;
import com.green.sahwang.usedproduct.entity.ImageEntity;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import com.green.sahwang.verifiedsale.entity.VerifiedSaleImage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ReviewService reviewService;

    private final UsedProductRepository usedProductRepository;
    private final ProductMapper productMapper;
    private final BrandMapper brandMapper;

    @Override
    @Transactional(readOnly = true)
    public List<BestProductResDto> getBestProducts() {
        List<BestProductResDto> bestProductResDtos = productMapper.findBestProduct();

        for (BestProductResDto bestProductResDto : bestProductResDtos) {
            Brand brand = brandMapper.findBrandById(bestProductResDto.getBrandId());
            bestProductResDto.setBrandName(brand.getName());
        }
        return bestProductResDtos;
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductForUsedResDto> getRandomProducts(int pageNum, int size) {
        Pageable pageable = PageRequest.of(pageNum, size);
        List<ProductWithSaleInfoDto> bestProductsWithRanks = productMapper.findBestProductsWithRank(pageable);
        return bestProductsWithRanks.stream()
                .map(bestProductWithRank -> getProductForUsedResDto(bestProductWithRank))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewUsedProductResDto> getNewProducts(int pageNum, int size) {
        Pageable pageable = PageRequest.of(pageNum, size);
        LocalDateTime startDate = LocalDateTime.now().minusDays(3);  // 3일 전 날짜 계산
        LocalDateTime now = LocalDateTime.now();
        Page<UsedProduct> allNewProducts = usedProductRepository.findAllNewProducts(startDate, pageable);

        log.info("usedProducts : {}", allNewProducts.getContent().size());

        return allNewProducts.stream()
                .map(usedProduct -> NewUsedProductResDto.builder()
                        .usedProductId(usedProduct.getId())
                        .productName(usedProduct.getVerifiedSale().getProductName())
                        .brandName(usedProduct.getVerifiedSale().getBrandName())
                        .gradeType(usedProduct.getUsedProductType().toString())
                        .price(usedProduct.getVerifiedSale().getPendingSale().getExceptedSellingPrice())
                        // 유저이미지로 할지, 검수이미지로 할지 정하기
                        .mainImage(usedProduct.getVerifiedSale().getPendingSale().getUserSaleImages().get(0).getFilename())
                        .registerDate(DateTimeUtils.formatWithoutSecond(usedProduct.getVerifiedSale().getPendingSale().getCreatedDate()))
                        .size(usedProduct.getVerifiedSale().getProductSize())
                        .gradeType(usedProduct.getVerifiedSale().getSaleGrade().getGradeType().toString())
                        .build()).toList();
    }

//    @NotNull
    public List<ProductResDto> getProductResDtos(List<Product> products) {
        return products.stream()
                .map(product -> getProductResDto(product))
                .toList();
    }

    /**
     * 중간페이지를 위한 제품서비스
     * @param
     * @return
     */
    public ProductForUsedResDto getProductForUsedResDto(ProductWithSaleInfoDto productWithSaleInfoDto) {
        Product product = productWithSaleInfoDto.getProduct();
        List<ProductImage> productImages = productImageRepository.findAllByProduct(product);
        List<ImageResDto> images = productImages.stream()
                .map(productImage -> {
                    ImageResDto imageResDto = new ImageResDto(
                            productImage.getFilename(),
                            productImage.getPath(),
                            productImage.getFileDesc()
                    );
                    return imageResDto;
                }).toList();

        ProductForUsedResDto productForUsedResDto = new ProductForUsedResDto(
                product.getId(),
                product.getName(),
                product.getContent(),
                product.getDtype(),
                product.getBrand().getName(),
                product.getSize(),
                product.getPrice(),
                reviewService.reviewCount(product),
                product.getRegisterDate() != null ? DateTimeUtils.format(product.getRegisterDate()) : null,
                !images.isEmpty() && images.get(0) != null ? images.get(0) : null,  // null 체크
                images,
                productWithSaleInfoDto.getMinPrice(),
                productWithSaleInfoDto.getMaxPrice(),
                productWithSaleInfoDto.getMinSize(),
                productWithSaleInfoDto.getMaxSize(),
                productWithSaleInfoDto.getGradeTypes(),
                productWithSaleInfoDto.getRankNumber()
        );
        return productForUsedResDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResDto> searchProducts(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return Collections.emptyList();
        }
        return getProductResDtos(productRepository.findByKeyword(keyword));
    }

    //    @NotNull
    public ProductResDto getProductResDto(Product product) {
        List<ProductImage> productImages = productImageRepository.findAllByProduct(product);
        List<ImageResDto> images = productImages.stream()
                .map(productImage -> {
                    ImageResDto imageResDto = new ImageResDto(
                            productImage.getFilename(),
                            productImage.getPath(),
                            productImage.getFileDesc()
                    );
                    return imageResDto;
                }).toList();

        ProductResDto productResDto = new ProductResDto(
                product.getId(),
                product.getName(),
                product.getContent(),
                product.getDtype(),
                product.getBrand().getName(),
                product.getSize(),
                product.getPrice(),
                reviewService.reviewCount(product),
                DateTimeUtils.format(product.getRegisterDate()),
                !images.isEmpty() && images.get(0) != null ? images.get(0) : null,  // null 체크
                images
        );
        return productResDto;
    }

    //    @NotNull
    public GeneralUsedProductResDto getUsedProductResDto(UsedProduct usedProduct) {
        List<UserSaleImage> userSaleImages = usedProduct.getVerifiedSale().getPendingSale().getUserSaleImages().stream()
                .filter(userSaleImage -> userSaleImage.isUsed())
                .toList();

        log.info("UserSaleImages : {}", userSaleImages);
        List<VerifiedSaleImage> verifiedSaleImages = usedProduct.getVerifiedSale().getVerifiedSaleImages();

        List<ImageResDto> images = new ArrayList<>();
        images.addAll(getImageList(userSaleImages));
        images.addAll(getImageList(verifiedSaleImages));

        return GeneralUsedProductResDto.builder()
                .usedProductId(usedProduct.getId())
                .productId(usedProduct.getVerifiedSale().getPendingSale().getProduct().getId())
                .productName(usedProduct.getVerifiedSale().getPendingSale().getProduct().getName())
                .brandName(usedProduct.getVerifiedSale().getPendingSale().getBrandName())
                .sellingUsedProductSize(usedProduct.getVerifiedSale().getProductSize())
                .dtype(usedProduct.getVerifiedSale().getPendingSale().getProduct().getDtype())
                .usedOrNot(usedProduct.getVerifiedSale().isUsedOrNot())
                .nickName(usedProduct.getVerifiedSale().getPendingSale().getMember().getNickName())
                .verifiedSaleGradeType(usedProduct.getVerifiedSale().getSaleGrade().getGradeType().toString())
                .sellingPrice(usedProduct.getVerifiedSale().getPendingSale().getExceptedSellingPrice())
                .userSaleImages(images)
                .registerDate(usedProduct.getCreatedDate() != null ? DateTimeUtils.format(usedProduct.getCreatedDate()) : null)
                .reviewCount(reviewService.reviewCount(usedProduct.getVerifiedSale().getPendingSale().getProduct()))
                .build();
    }

    @NotNull
    private static List<ImageResDto> getImageList(List<? extends ImageEntity> images) {
        return images.stream()
                .map(image -> new ImageResDto(
                            image.getFilename(),
                            image.getPath(),
                            image.getFileDesc()
                )).toList();
    }
}
