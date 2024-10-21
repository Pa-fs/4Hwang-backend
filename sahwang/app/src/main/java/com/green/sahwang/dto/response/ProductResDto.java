package com.green.sahwang.dto.response;

import com.green.sahwang.entity.Brand;
import lombok.Data;

import java.util.List;

@Data
public class ProductResDto {

    private String name;

    private String content;

    private String type;

    private String brandName;

    private int price;

    // review Service 만들어서
    private int reviewCount;

    private List<ProductImageResDto> imageList;

}
