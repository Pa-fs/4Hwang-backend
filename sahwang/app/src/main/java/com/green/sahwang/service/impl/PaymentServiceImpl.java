package com.green.sahwang.service.impl;

import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.repository.PurchaseRepository;
import com.green.sahwang.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PurchaseRepository purchaseRepository;

    @Override
    @Transactional
    public void processPayment(List<String> purchaseIds, List<PurchaseCreatedEventAvroModel> messages) {

        for (String purchaseId : purchaseIds) {
            String PREFIX = purchaseId.split(":")[0];
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            Purchase purchase = purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));

            if (purchase.getPurchaseStatus() != PurchaseStatus.CREATED) {
                continue;
            }

            purchase.setPurchaseStatus(PurchaseStatus.PAY_WAIT);
            purchaseRepository.save(purchase);


            List<PurchaseCreatedEventAvroModel> collect = messages.stream().collect(Collectors.toList());



            log.info("purchaseId, PREFIX : {}, VALUE : {}", PREFIX, purchaseKeyId);
        }
    }
}
