package com.green.sahwang.detail.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetailChartResDto {

    private int tradePrice;
    private String tradeCompletedDate;
    int size;

}
