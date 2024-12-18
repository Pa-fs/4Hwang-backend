package com.green.sahwang.mypage.dto.res;

import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.pendingsale.entity.UserSaleImage;
import com.green.sahwang.verifiedsale.entity.enumtype.GradeType;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishListProductResDto {

    private Long productId;

    private String productName;

    private int price;

    private int size;

    private GradeType gradeType;

    private List<ImageResDto> userSaleImages;

}
