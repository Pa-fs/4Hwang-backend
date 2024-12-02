package com.green.sahwang.mypage.dto.req;

import com.green.sahwang.dto.request.ImageFileReqDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateReqDto {

    private Long purchaseProductId;

    private String content;

    private double Star;

    private ReviewImageReqDto reviewImageReqDto;

}
