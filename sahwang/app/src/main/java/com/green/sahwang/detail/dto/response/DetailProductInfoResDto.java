package com.green.sahwang.detail.dto.response;

import com.green.sahwang.dto.response.ImageResDto;
import lombok.Data;

import java.util.List;

@Data
public class DetailProductInfoResDto {

    String brandName;
    String productName;
    Long productId;
    int size;
    int price;
    ImageResDto mainImage;

}
