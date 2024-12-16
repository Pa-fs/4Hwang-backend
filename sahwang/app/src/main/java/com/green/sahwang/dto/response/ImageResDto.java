package com.green.sahwang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ImageResDto {

    private String filename;
    private String path;
    private String fileDesc;
}
