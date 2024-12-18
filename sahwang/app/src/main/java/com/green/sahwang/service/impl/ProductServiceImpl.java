package com.green.sahwang.service.impl;

import com.green.sahwang.config.DateTimeUtils;
import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.dto.response.ProductForUsedResDto;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.dto.response.ProductWithSaleInfoDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.pendingsale.entity.UserSaleImage;
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
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ReviewService reviewService;

    private final UsedProductRepository usedProductRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResDto> getBestProducts(int pageNum, int size) {
        Pageable pageable = PageRequest.of(pageNum, size);
        List<Product> bestProducts = productRepository.findBestProducts(pageable);
        return getProductResDtos(bestProducts);
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductResDto> getRandomProducts(int pageNum, int size) {
        Pageable pageable = PageRequest.of(pageNum, size);
        List<Product> randomProducts = productRepository.findRandomProducts(pageable);
        return getProductResDtos(randomProducts);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResDto> getNewProducts(int pageNum, int size) {
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by("registerDate").descending());
        Page<Product> products = productRepository.findAll(pageable);
        return getProductResDtos(products.stream().toList());
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
                productWithSaleInfoDto.getGradeTypes()
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
                .sellingUsedProductSize(usedProduct.getVerifiedSale().getPendingSale().getExceptedSellingPrice())
                .nickName(usedProduct.getVerifiedSale().getPendingSale().getMember().getNickName())
                .verifiedSaleGradeType(usedProduct.getVerifiedSale().getSaleGrade().getGradeType().toString())
                .images(images)
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
