package com.green.sahwang.service;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResDto> getRandomProducts(int pageNum, int size);

    List<ProductResDto> getNewProducts(int pageNum, int size);

    List<ProductResDto> getBestProducts(int pageNum, int size);
}
