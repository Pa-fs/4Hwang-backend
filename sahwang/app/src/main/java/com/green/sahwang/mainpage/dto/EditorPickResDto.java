package com.green.sahwang.mainpage.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditorPickResDto {

    private Long productId;
    private String fileName;
    private String brandName;
    private String productName;
    private int minPrice;
    private int maxPrice;
    private String content;
    private int size;
    private Long usedProductCount;

}
