package com.green.sahwang.mypage.dto.res;

import com.green.sahwang.entity.enumtype.SaleStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleListResDto {
    LocalDateTime createdDate;
    Long id;
    SaleStatus saleStatus;
    List<SaleDetailResDto> saleDetailResDtoList;
}
