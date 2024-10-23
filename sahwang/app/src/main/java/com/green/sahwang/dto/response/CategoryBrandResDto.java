package com.green.sahwang.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryBrandResDto {
    private List<BrandProductResDto> brandProductResponses;
    public CategoryBrandResDto(List<BrandProductResDto> brandProductResponses) {
        this.brandProductResponses = brandProductResponses;
    }
}
