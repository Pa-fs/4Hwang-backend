package com.green.sahwang.mypage.dto.res;

import com.green.sahwang.mypage.dto.WishListCategoryDto;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishListCategoryResDto {

    private WishListCategoryDto wishListCategoryDto;

    private int productCount;

}
