package com.green.sahwang.service.impl;

import com.green.sahwang.dto.response.BestProductResDto;
import com.green.sahwang.dto.response.ProductImageResDto;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.repository.ProductImageRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    @Override
    @Transactional
    public List<Product> productList(){
        return productRepository.findAll();
    }

    public List<BestProductResDto> bestProductList(){
        BestProductResDto bestProductResDto = new BestProductResDto();
        List<ProductResDto> productResDtos = new ArrayList<>();
        List<ProductImageResDto> productImageResDtos = new ArrayList<>();

        return null;
    }

}
