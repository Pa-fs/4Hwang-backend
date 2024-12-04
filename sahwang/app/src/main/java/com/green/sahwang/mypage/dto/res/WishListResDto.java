package com.green.sahwang.mypage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListResDto {

    Long productId;

    String productName;

    int productPrice;

    int size;

    String mainImage;

}
