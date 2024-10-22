package com.green.sahwang.service.impl.category;

import com.green.sahwang.dto.response.BrandProductResDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryBrandResponse {
    private List<BrandProductResDto> brandProductResponses;
    public CategoryBrandResponse(List<BrandProductResDto> brandProductResponses) {
        this.brandProductResponses = brandProductResponses;
    }
}
