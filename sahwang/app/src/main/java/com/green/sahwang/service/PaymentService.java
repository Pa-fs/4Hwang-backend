package com.green.sahwang.service;

import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;

import java.util.List;

public interface PaymentService {

    void processPayment(List<String> purchaseIds, List<PurchaseCreatedEventAvroModel> messages);
}
