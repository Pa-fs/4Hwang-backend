package com.green.sahwang.mypage.dto;

import com.green.sahwang.verifiedsale.entity.enumtype.GradeType;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishListProductDto {

    private Long productId;

    private String productName;

    private int price;

    private int size;

    private GradeType gradeType;

    private String image;

}
