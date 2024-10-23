package com.green.sahwang.dto.request;

import lombok.Data;

@Data
public class ImageFileReqDto {

    private Long productId;
    private String name;
    private String path;
    private String desc;
}
