package com.green.sahwang.usedproduct.dto.response;

import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.inspection.dto.response.UserSaleResImage;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsedProductResDto {

    private Long productId;
    private Long usedProductId;
    private String productName;
    private String nickName;
    private String brandName;
    private String verifiedSaleGradeType;
    private int sellingPrice;
    private int productSize;
    private List<ImageResDto> userSaleImages;
}
