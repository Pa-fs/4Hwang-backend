package com.green.sahwang.verifiedsale.repository;

import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.verifiedsale.entity.RejectionReason;
import com.green.sahwang.verifiedsale.entity.VerifiedSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerifiedSaleRepository extends JpaRepository<VerifiedSale, Long> {

    List<VerifiedSale> findAllByPendingSaleIn(List<PendingSale> pendingSaleList);

    List<VerifiedSale> findAllByUsedProductInAndRejectionReason(List<UsedProduct> usedProductList, RejectionReason rejectionReason);
}
