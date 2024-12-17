package com.green.sahwang.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListCategoryDto {

    private Boolean isChecked;

    private Long id;

    private String name;

    private String mainImage;

}
