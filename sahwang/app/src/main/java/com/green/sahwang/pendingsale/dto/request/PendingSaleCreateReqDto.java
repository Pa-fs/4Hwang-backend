package com.green.sahwang.pendingsale.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "판매신청 정보")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingSaleCreateReqDto {

    private String seller;
    private String productName;
    private String categoryName;
    private int productSize;
    private int expectedSellingPrice;
    private String brandName;
    private boolean usedOrNot;
    private String productContent;
    private int quantity;
    private List<UserSaleReqImageDto> userSaleReqImageDtos;
}
