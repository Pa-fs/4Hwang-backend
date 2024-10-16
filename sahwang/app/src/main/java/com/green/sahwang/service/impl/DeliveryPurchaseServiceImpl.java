package com.green.sahwang.service.impl;

import com.green.sahwang.entity.Purchase;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.service.DeliveryPurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryPurchaseServiceImpl implements DeliveryPurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    @Transactional
    public void processDeliveryPurchase(List<String> purchaseIds, List<PurchasePaidEventAvroModel> messages) {

        for (String purchaseId : purchaseIds) {
            String PREFIX = purchaseId.split(":")[0];
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            Purchase purchase = purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));

            // Idempotency
            purchase.doReadyForShip();

            log.info("해당 구매번호 : {}, 배송 준비 중", purchaseKeyId);
        }
    }
}
