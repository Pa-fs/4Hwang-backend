package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.entity.enumtype.ShipStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderManageResDto {
    private Long purchaseProductId;
    private String productName;
    private String brandName;
    private String usedProductName;
    private int productSize;
    private String category;
    private int price;
    private LocalDateTime purchaseCreationDate;
    private PurchaseStatus purchaseStatus;
    private String nickName;
    private String name;
    private LocalDateTime deliveredDate;
    private ShipStatus shipStatus;
    private String filename;
}
