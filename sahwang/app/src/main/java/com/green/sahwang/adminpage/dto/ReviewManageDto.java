package com.green.sahwang.adminpage.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewManageDto {

    private Long reviewId;

    private String reviewImage;

    private String productName;

    private int size;

    private String dtype;

    private String content;

    private double star;

    private String nickName;

    private LocalDateTime reviewCreationDate;

}