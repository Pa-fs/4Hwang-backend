package com.green.sahwang.mypage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResDto {

    private LocalDateTime deliveredDate;
    private String productName;
    private int price;
    private int quantity;

}
