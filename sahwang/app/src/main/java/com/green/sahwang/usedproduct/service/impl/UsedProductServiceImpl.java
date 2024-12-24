package com.green.sahwang.usedproduct.service.impl;

import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Purchase;
import com.green.sahwang.entity.PurchaseProduct;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.repository.*;
import com.green.sahwang.usedproduct.dto.response.UsedProductResDto;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.entity.enumtype.UsedProductType;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import com.green.sahwang.usedproduct.service.UsedProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsedProductServiceImpl implements UsedProductService {

    private final UsedProductRepository usedProductRepository;
    private final MemberRepository memberRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final SalePaymentRepository salePaymentRepository;
    private final PurchasePaymentRepository purchasePaymentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UsedProductResDto> getUsedProducts(Long productId, int pageNum, int size, String sortType) {
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(Sort.Direction.DESC, sortType));
        Page<UsedProduct> usedProducts = usedProductRepository.findUsedProductsByProductId(productId, UsedProductType.USER_ACCEPT ,pageable);
        return usedProducts.stream()
                .map(up -> UsedProductResDto.builder()
                        .productId(productId)
                        .sellingPrice(up.getVerifiedSale().getPendingSale().getExceptedSellingPrice())
                        .productSize(up.getVerifiedSale().getProductSize())
                        .usedProductId(up.getId())
                        .productName(up.getVerifiedSale().getProductName())
                        .brandName(up.getVerifiedSale().getBrandName())
                        .nickName(up.getVerifiedSale().getPendingSale().getMember().getNickName())
                        .verifiedSaleGradeType(up.getVerifiedSale().getSaleGrade().getGradeType().toString())
                        .usedOrNot(up.getVerifiedSale().isUsedOrNot())
                        .userSaleImages(
                                up.getVerifiedSale().getPendingSale().getUserSaleImages()
                                        .stream().map(image -> ImageResDto.builder()
                                                .path(image.getPath())
                                                .filename(image.getFilename())
                                                .fileDesc(image.getFileDesc())
                                                .build())
                                        .toList())
                        .build())
                .toList();
    }

    @Override
    @Transactional
    public void soldOutUsedProduct(List<String> memberIds, List<PurchasePaidEventAvroModel> messages) {
        for (String memberId : memberIds) {
            String memberKeyId = memberId.split(":")[1];
            log.info("memberKeyId = {}", memberKeyId);

            Member member = memberRepository.findById(Long.valueOf(memberKeyId))
                    .orElseThrow(() -> new BizException(ErrorCode.NO_MEMBER));

            List<PurchasePaidEventAvroModel> purchasePaidEventAvroModels = messages.stream().toList();
            for (PurchasePaidEventAvroModel purchasePaidEventAvroModel : purchasePaidEventAvroModels) {
                log.info("purchasePaidEventAvroModel.getPurchaseId() : {}", purchasePaidEventAvroModel.getPurchaseId());
                Purchase purchase = purchaseRepository.findById(Long.valueOf(purchasePaidEventAvroModel.getPurchaseId()))
                        .orElseThrow(() -> new BizException(ErrorCode.NO_PURCHASE));
                log.info("{}", purchase.getPurchaseStatus());

                List<PurchaseProduct> purchaseProducts = purchaseProductRepository.findAllByPurchase(purchase);
                log.info("판매처리 전 purchaseProducts 사이즈 : {}", purchaseProducts.size());
                for (PurchaseProduct purchaseProduct : purchaseProducts) {
                    // 상품 판매처리
                    UsedProduct usedProduct = usedProductRepository.findById(purchaseProduct.getUsedProduct().getId())
                            .orElseThrow(() -> new BizException(ErrorCode.NO_USED_PRODUCT));
                    usedProduct.setSoldOut(true);
                    usedProductRepository.save(usedProduct);
                    log.info("usedProduct Id : {}, 판매처리", usedProduct.getId());
                }
            }
        }
    }
}
