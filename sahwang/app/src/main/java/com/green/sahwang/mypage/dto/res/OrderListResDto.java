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
    private String categoryName;
    private String brandName;
    private String productName;
    private int productSize;
    private int expectedSellingPrice;
    private LocalDateTime purchaseCreationDate;
    private PurchaseStatus purchaseStatus;
    private String filename;

}
