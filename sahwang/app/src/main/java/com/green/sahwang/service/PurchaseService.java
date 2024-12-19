package com.green.sahwang.service;

import com.green.sahwang.purchase.dto.request.PurchaseReqDto;
import com.green.sahwang.purchase.dto.response.PurchaseResDto;
import com.green.sahwang.dto.response.externalapi.ExternalPaymentResDto;

public interface PurchaseService {

//    void createPurchase(String memberId, List<Product> products);
      PurchaseResDto createPurchase(PurchaseReqDto purchaseReqDto, String userEmail);

      ExternalPaymentResDto purchaseCompleted(String merchantUid);
}
