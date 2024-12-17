package com.green.sahwang.service.impl;

import com.green.sahwang.config.DateTimeUtils;
import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.dto.response.ProductForUsedResDto;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.dto.response.ProductWithSaleInfoDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.repository.ProductImageRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.service.ProductService;
import com.green.sahwang.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ReviewService reviewService;

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
}
