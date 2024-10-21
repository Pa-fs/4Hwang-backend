package com.green.sahwang.service.impl.category;

import com.green.sahwang.dto.response.BrandProductResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryBrandResponse {
    private List<BrandProductResponse> brandProductResponses;
    public CategoryBrandResponse(List<BrandProductResponse> brandProductResponses) {
        this.brandProductResponses = brandProductResponses;
    }
}
