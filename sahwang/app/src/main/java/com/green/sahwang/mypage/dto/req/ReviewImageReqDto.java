package com.green.sahwang.mypage.dto.req;

import lombok.Data;

@Data
public class ReviewImageReqDto {

    private Long reviewId;
    private String name;
    private String path;
    private String desc;

}
