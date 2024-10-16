package com.green.sahwang.service;

import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;

import java.util.List;

public interface DeliveryPurchaseService {

    void processDeliveryPurchase(List<String> purchaseIds, List<PurchasePaidEventAvroModel> messages);
}
