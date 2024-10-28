package com.green.sahwang.detail.service;

import com.green.sahwang.detail.dto.response.DetailChartResDto;
import com.green.sahwang.detail.dto.response.DetailImagesResDto;
import com.green.sahwang.detail.error.SalePaymentException;
import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.entity.SaleProduct;
import com.green.sahwang.repository.ProductImageRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.SalePaymentRepository;
import com.green.sahwang.repository.SaleProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductDetailPageServiceImpl implements ProductDetailService{

    private final SaleProductRepository saleProductRepository;
    private final SalePaymentRepository salePaymentRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;

    public List<DetailChartResDto> getSaleProducts(Long productId){
        Optional<SaleProduct> optionalSaleProduct = saleProductRepository.findById(productId);

        salePaymentRepository.findBySaleProduct(optionalSaleProduct.orElse(null)).orElseThrow(()->new SalePaymentException("결제 완료된 판매 내역이 없습니다"));

        return optionalSaleProduct
                .stream()
                .map(saleProduct -> {
                    DetailChartResDto detailChartResDto = new DetailChartResDto();
                    detailChartResDto.setTradeCompletedDate(saleProduct.getTradeCompletedDate());
                    detailChartResDto.setTradePrice(saleProduct.getTradePrice());
                    return detailChartResDto;
                })
                .collect(Collectors.toList());
    }

    public DetailImagesResDto getProductImages(Long productId){
        Product product = productRepository.findById(productId)
                .orElse(null);
        List<ProductImage> productImages = productImageRepository.findByProduct(product);

        List<ImageResDto> imageResDtoList = new ArrayList<>();
        for (ProductImage productImage : productImages) {
            imageResDtoList.add(new ImageResDto(productImage.getFilename(), productImage.getPath(), productImage.getFileDesc()));
        }
        DetailImagesResDto detailImagesResDto = new DetailImagesResDto();
        detailImagesResDto.setImages(imageResDtoList);

        return detailImagesResDto;
    }

}
