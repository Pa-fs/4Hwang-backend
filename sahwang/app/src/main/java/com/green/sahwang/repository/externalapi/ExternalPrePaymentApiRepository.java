package com.green.sahwang.repository.externalapi;

import com.green.sahwang.entity.externalapi.PrePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExternalPrePaymentApiRepository extends JpaRepository<PrePaymentEntity, Long> {

   Optional<PrePaymentEntity> findByPurchaseId(Long purchaseId);

   Optional<PrePaymentEntity> findByMerchantUid(String merchantUid);
}
