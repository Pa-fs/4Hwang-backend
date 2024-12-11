package com.green.sahwang.dto.response;

import com.green.sahwang.brand.entity.Brand;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrandProductResDto {

    private Long brandId;
    private String brandName;
    private List<ProductResInBrandDto> products;

    public BrandProductResDto(Brand brand, List<ProductResInBrandDto> products) {
        this.brandId = brand.getId();
        this.brandName = brand.getName();
        this.products = products;
    }
}
