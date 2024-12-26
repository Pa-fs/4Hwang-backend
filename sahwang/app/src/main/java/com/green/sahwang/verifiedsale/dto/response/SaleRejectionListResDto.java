package com.green.sahwang.verifiedsale.dto.response;

import com.green.sahwang.dto.response.ImageResDto;
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
public class SaleRejectionListResDto {
    private Long memberId;
    private Long productId;
    private Long pendingSaleId;
    private Long verifiedSaleId;
    private Long usedProductId;
    private String seller;
    private LocalDateTime registerDate;
    private String verifiedCategory;
    private String verifiedBrand;
    private String productName;
    private int userPrice;
    private String verifiedSize;
    private int verifiedPrice;
    private boolean verifiedUsedOrNot;
    private String usedProductType;
    private String rejectionReason;
    private String representativeImage;
    private List<ImageResDto> userImages;
    private List<ImageResDto> verifiedImages;
}
