package com.green.sahwang.service;

import com.green.sahwang.dto.request.PurchaseReqDto;
import com.green.sahwang.dto.response.PurchaseResDto;

public interface PurchaseService {

//    void createPurchase(String memberId, List<Product> products);
      PurchaseResDto createPurchase(PurchaseReqDto purchaseReqDto);
}
