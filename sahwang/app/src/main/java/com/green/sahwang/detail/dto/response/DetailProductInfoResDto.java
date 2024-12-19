package com.green.sahwang.detail.dto.response;

import com.green.sahwang.dto.response.ImageResDto;
import lombok.Data;

import java.util.List;

@Data
public class DetailProductInfoResDto {

    private String brandName;
    private String productName;
    private Long productId;
    private int size;
    private int price;
    private ImageResDto mainImage;

}
