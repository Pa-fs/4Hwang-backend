package com.green.sahwang.mypage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyReviewResDto {

    private Long reviewId;

    private String content;

    private String reviewImage;

    private LocalDateTime createDate;

    private double star;

    private Long memberId;

    private Long purchaseProductId;

    private String productName;

    private int size;

    private int reviewCount;

}
