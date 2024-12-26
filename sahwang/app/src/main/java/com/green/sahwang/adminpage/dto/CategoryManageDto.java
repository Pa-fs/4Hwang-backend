package com.green.sahwang.adminpage.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryManageDto {

    private Long productId;

    private String productName;

    private int size;

    private String dtype;

    private String brandName;

    private Long usedProductCount;

    private String filename;

}
