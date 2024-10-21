package com.green.sahwang.dto.response;

import com.green.sahwang.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class BestProductResDto {

    private List<ProductResDto> productList;

    private int totalSoldCnt; // 비즈니스 로직에서 코드 짜서 추가해야 된다

}
