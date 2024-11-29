package com.green.sahwang.mypage.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetailResDto {

    LocalDateTime doneDate;
    String productName;
    int price;
    int quantity;

}
