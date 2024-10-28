package com.green.sahwang.service.impl.payment.helper;

import com.green.sahwang.entity.Purchase;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceHelper {

    private final PurchaseRepository purchaseRepository;

    public Purchase getPurchase(List<String> purchaseIds) {
        for (String purchaseId : purchaseIds) {
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            return purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));
        }

        return null;
    }
}
