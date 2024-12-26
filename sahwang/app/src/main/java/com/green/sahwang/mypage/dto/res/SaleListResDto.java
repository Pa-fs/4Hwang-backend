package com.green.sahwang.mypage.dto.res;

import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.enumtype.SaleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleListResDto {
    private Long pendingSaleId;
    private Long verifiedSaleId;
    private Long usedProductId;
    private String userCategory;
    private String userBrand;
    private String saleStatus;
    private String productName;
    private int userPrice;
    private int userSize;
    private boolean userUsedOrNot;
    private String verifiedSize;
    private int verifiedPrice;
    private boolean verifiedUsedOrNot;
    private String usedProductType;
    private String gradeType;
    private String reason;
    private List<ImageResDto> userImages;
    private List<ImageResDto> verifiedImages;
}
