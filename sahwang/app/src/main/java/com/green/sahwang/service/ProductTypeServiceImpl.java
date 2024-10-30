package com.green.sahwang.service;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductProductType;
import com.green.sahwang.entity.ProductType;
import com.green.sahwang.entity.enumtype.ProductTypeGroup;
import com.green.sahwang.repository.ProductProductTypeRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.ProductTypeRepository;
import com.green.sahwang.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService{

    private final ProductTypeRepository productTypeRepository;
    private final ProductProductTypeRepository productProductTypeRepository;
    private final ProductRepository productRepository;
    private final ProductServiceImpl productService;

    @Transactional
    public List<ProductResDto> getProductResDtoByGroup(ProductTypeGroup productTypeGroup){
        List<ProductType> productTypeList = productTypeRepository.findAllByProductTypeGroup(productTypeGroup);

        List<Long> productTypeListId = productTypeList.stream()
                .map(ProductType::getId)
                .toList();

        List<ProductProductType> productProductTypeList = productProductTypeRepository.findAllById(productTypeListId);

        List<Long> productProductTypeListProductId = productProductTypeList.stream()
                .map(productProductType -> productProductType.getProduct().getId())
                .toList();

        List<Product> productList = productRepository.findAllById(productProductTypeListProductId);

        return productList.stream()
                .map(product -> productService.getProductResDto(product))
                .toList();
    }

}
