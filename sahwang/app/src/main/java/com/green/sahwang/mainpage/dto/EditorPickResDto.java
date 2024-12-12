package com.green.sahwang.mainpage.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EditorPickResDto {

    private Long productId;
    private String fileName;
    private String brandName;
    private String productName;
    private int price;
    private String content;
    private int size;

}
