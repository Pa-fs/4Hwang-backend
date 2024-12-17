package com.green.sahwang.mypage.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WishListCategoryDto {

    private Boolean isChecked;

    private Long id;

    private String name;

    private String mainImage;

}
