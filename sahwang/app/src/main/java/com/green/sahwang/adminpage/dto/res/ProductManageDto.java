package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.inspection.enumtype.InspectionStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductManageDto {

    private Long usedProductId;

    private String productName;

    private String brandName;

    private String filename;

    private int productSize;

    private int productPrice;

    private String category;

    private InspectionStatus status;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

}
