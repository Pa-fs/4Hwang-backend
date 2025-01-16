package com.green.sahwang.payment.repository.externalapi;

import com.green.sahwang.payment.entity.externalapi.PostPaymentEntity;
import com.green.sahwang.payment.entity.externalapi.PrePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExternalPostPaymentApiRepository extends JpaRepository<PostPaymentEntity, Long> {

    Optional<PostPaymentEntity> findByMerchantUid(String merchantUid);
}
