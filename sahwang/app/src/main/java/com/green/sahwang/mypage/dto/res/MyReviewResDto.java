package com.green.sahwang.mypage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyReviewResDto {

    Long reviewId;

    String content;

    String reviewImage;

    LocalDateTime createDate;

    LocalDateTime modifiedDate;

    double star;

    Long memberId;

    Long purchaseProductId;

}
