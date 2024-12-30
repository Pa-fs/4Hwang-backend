package com.green.sahwang.mypage.dto.res;

import com.green.sahwang.entity.enumtype.PurchaseStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderListResDto {

    private Long purchaseProductId;
    private String productName;
    private String brandName;
    private String saleProductName;
    private String productSize;
    private Double expectedSellingPrice;
    private LocalDateTime purchaseCreationDate;
    private String purchaseStatus;
    private String filename;

}
