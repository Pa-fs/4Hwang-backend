package com.green.sahwang.sale.service;

import com.green.sahwang.sale.dto.SaleCreateReqDto;
import com.green.sahwang.sale.dto.SaleCreatedResDto;

public interface SaleService {

    SaleCreatedResDto createSale(SaleCreateReqDto saleCreatedDto, String email);

}
