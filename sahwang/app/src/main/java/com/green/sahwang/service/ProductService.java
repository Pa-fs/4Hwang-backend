package com.green.sahwang.service;

import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.mainpage.dto.BestProductResDto;
import com.green.sahwang.mainpage.dto.NewUsedProductResDto;

import java.util.List;

public interface ProductService {
    List<ProductResDto> getRandomProducts(int pageNum, int size);

    List<NewUsedProductResDto> getNewProducts(int pageNum, int size);

    List<BestProductResDto> getBestProducts();

    List<ProductResDto> searchProducts(String keyword);
}
