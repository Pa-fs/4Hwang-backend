package com.green.sahwang.pendingsale.dto.request;

import com.green.sahwang.dto.request.ImageFileReqDto;
import com.green.sahwang.pendingsale.dto.request.UserSaleReqImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<UserSaleReqImage> userSaleReqImages;
}
