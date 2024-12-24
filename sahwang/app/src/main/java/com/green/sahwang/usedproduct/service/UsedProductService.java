package com.green.sahwang.usedproduct.service;

import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.usedproduct.dto.response.UsedProductResDto;

import java.util.List;

public interface UsedProductService {

    List<UsedProductResDto> getUsedProducts(Long productId, int pageNum, int size, String sortType);

    void soldOutUsedProduct(List<String> keys, List<PurchasePaidEventAvroModel> messages);
}
