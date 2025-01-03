package com.green.sahwang.adminpage.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashReviewListDto {

    private Long reviewId;

    private String content;

    private LocalDateTime reviewCreateDate;

    private String brandName;

    private String categoryName;

    private String productName;

    private int productSize;

    private String nickName;

}
