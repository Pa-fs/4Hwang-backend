package com.green.sahwang.service;

import com.green.sahwang.dto.request.PaymentCompleteRequest;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;

import java.util.List;

public interface PaymentService {

    void processPayment(List<String> purchaseIds, List<PurchaseCreatedEventAvroModel> messages);

    void processAsyncPayment(PaymentCompleteRequest paymentCompleteRequest);

    void validateOrder(List<String> purchaseIds, List<PurchaseCreatedEventAvroModel> messages);
}
