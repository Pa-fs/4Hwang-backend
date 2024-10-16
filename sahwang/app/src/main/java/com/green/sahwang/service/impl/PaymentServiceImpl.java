package com.green.sahwang.service.impl;

import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchasePayment;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.DomainExcepton;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.model.purchase.avro.ProductAvroModel;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.repository.PurchaseProductRepository;
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
    private final PurchaseProductRepository purchaseProductRepository;

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


            // PaymentServiceHelper ...
            List<PurchaseCreatedEventAvroModel> collect = messages.stream().collect(Collectors.toList());
            for (PurchaseCreatedEventAvroModel purchaseCreatedEventAvroModel : collect) {

                List<ProductAvroModel> products = purchaseCreatedEventAvroModel.getProducts();
                for (ProductAvroModel productAvroModel : products) {
                    String productId = productAvroModel.getProductId();
                    PurchaseProduct purchaseProduct = purchaseProductRepository.findByProductIdAndPurchaseId(Long.valueOf(productId),
                                    Long.valueOf(purchaseKeyId))
                            .orElseThrow(() -> new PurchaseDomainException("주문 상품 내역이 존재하지 않습니다."));

                    log.info("주문상품 : {}, 상품 ID : {}", purchaseProduct.toString(), purchaseProduct.getProduct().getId());
                }
            }

            log.info("purchaseId, PREFIX : {}, VALUE : {}", PREFIX, purchaseKeyId);
        }
    }
}
