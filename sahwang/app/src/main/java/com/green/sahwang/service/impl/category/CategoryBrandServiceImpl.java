package com.green.sahwang.service.impl.category;

import com.green.sahwang.dto.response.*;
import com.green.sahwang.entity.Brand;
import com.green.sahwang.entity.Category;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.exception.CategoryDomainException;
import com.green.sahwang.repository.*;
import com.green.sahwang.service.ReviewService;
import com.green.sahwang.service.category.CategoryBrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryBrandServiceImpl implements CategoryBrandService {

    private final CategoryRepository categoryRepository;
    private final CategoryBrandRepository categoryBrandRepository;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ReviewService reviewService;

    @Override
    @Transactional
    public List<ProductResDto> getProductsByCategory(Long categoryId, int pageNum, int size, String sortType) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryDomainException("해당 카테고리는 존재하지 않습니다"));
        // 개선 여지 코드
        String dType = String.valueOf(category.getName().charAt(0)).toUpperCase();

        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(Sort.Direction.DESC, sortType));
        List<Product> products = productRepository.findProductsByDtype(pageable, dType);

        List<ProductResDto> productResDtoList = products.stream()
                .map(product -> {
                    List<ProductImage> productImages = productImageRepository.findByProduct(product);

                    List<ImageResDto> imageResponses = productImages.stream()
                            .map(image -> new ImageResDto(image.getFilename(), image.getPath(), image.getFileDesc()))
                            .toList();

                    return new ProductResDto(product.getId(),
                            product.getName(),
                            product.getContent(),
                            product.getDtype(),
                            product.getBrand().getName(),
                            product.getPrice(),
                            reviewService.reviewCount(product),
                            imageResponses  // 이미지 리스트 포함
                    );
                })
                .toList();

        return productResDtoList;
    }

    @Transactional(readOnly = true)
    public CategoryBrandResDto getBrandsAndProductsByCategory(Long categoryId, int pageNum, int size, String sortType) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryDomainException("해당 카테고리는 존재하지 않습니다"));
        List<Brand> brands = categoryBrandRepository.findBrandsByCategoryId(categoryId);
        // 개선 여지 코드
        String dType = String.valueOf(category.getName().charAt(0)).toUpperCase();


//        브랜드별 8개씩 조회
//        List<BrandProductResponse> brandProductResponses = brands.stream()
//                .map(brand -> {
//                    Pageable pageable = PageRequest.of(pageNum, size, Sort.by(Sort.Direction.DESC, sortType));
//                    List<Product> products = productRepository.findProductsByBrand(brand, pageable);
//                    return new BrandProductResponse(brand, products);
//                })
//                .toList();

        int totalLimit = size;
        int totalSum = 0;
        int currentPage = pageNum;

        List<BrandProductResDto> brandProductResponses = new ArrayList<>();

        for (Brand brand : brands) {
            // 남은 상품 수가 없으면 종료
            if (totalSum >= totalLimit) {
                break;
            }

            // 각 브랜드마다 페이징으로 상품 조회
            Pageable pageable = PageRequest.of(pageNum, size, Sort.by(Sort.Direction.DESC, sortType));
            List<Product> products = productRepository.findProductsByBrandAndDtype(brand, pageable, dType);

            // 남은 개수만큼 상품을 제한해서 가져옴
            int remainingSlots = totalLimit - totalSum;
            List<ProductResInBrandDto> limitedProducts = products.stream()
                    .map(product -> {
                        List<ProductImage> productImages = productImageRepository.findByProduct(product);

                        List<ImageResDto> imageResponses = productImages.stream()
                                .map(image -> new ImageResDto(image.getFilename(), image.getPath(), image.getFileDesc()))
                                .toList();

                        return new ProductResInBrandDto(
                                product.getId(),
                                product.getName(),
                                product.getPrice(),
                                imageResponses  // 이미지 리스트 포함
                        );
                    })
                    .limit(remainingSlots)
                    .toList();

            brandProductResponses.add(new BrandProductResDto(brand, limitedProducts));

            // 가져온 상품 누적
            totalSum += limitedProducts.size();

            // 만약 현재 브랜드에서 가져온 상품이 적어서, 다음 브랜드에서 새로운 페이지로 상품을 가져와야 할 경우
            if (limitedProducts.size() < totalLimit) {
                currentPage++; // 다음 페이지로 넘어감
            }
        }

        return new CategoryBrandResDto(brandProductResponses);
    }
}
