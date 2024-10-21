package com.green.sahwang.dto.response;

import com.green.sahwang.entity.Brand;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.repository.ProductImageRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BrandProductResponse {

    private Long brandId;
    private String brandName;
    private List<ProductResponse> products;

    public BrandProductResponse(Brand brand, List<ProductResponse> products) {
        this.brandId = brand.getId();
        this.brandName = brand.getName();
        this.products = products;
    }
}
