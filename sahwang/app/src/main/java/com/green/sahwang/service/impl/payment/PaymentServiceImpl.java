package com.green.sahwang.service.impl.payment;

import com.green.sahwang.config.AvroToDBSerializer;
import com.green.sahwang.dto.request.PaymentCompleteRequest;
import com.green.sahwang.dto.request.externalapi.ExternalPaymentReqDto;
import com.green.sahwang.dto.request.externalapi.ExternalPurchasePaymentReqDto;
import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.OutboxStatus;
import com.green.sahwang.entity.enumtype.PaymentType;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.entity.enumtype.SystemLogicType;
import com.green.sahwang.entity.externalapi.ExternalPrePaymentReqDto;
import com.green.sahwang.entity.externalapi.PrePaymentEntity;
import com.green.sahwang.exception.outbox.OutboxSerializeEventException;
import com.green.sahwang.exception.PurchaseDomainException;
import com.green.sahwang.exception.payment.PaymentDomainException;
import com.green.sahwang.model.payment.avro.PaymentMethod;
import com.green.sahwang.model.payment.avro.PaymentStatus;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.model.purchase.avro.PurchaseAvroModel;
import com.green.sahwang.model.purchase.avro.PurchaseCreatedEventAvroModel;
import com.green.sahwang.repository.*;
import com.green.sahwang.repository.externalapi.ExternalPrePaymentApiRepository;
import com.green.sahwang.service.PaymentService;
import com.green.sahwang.service.impl.payment.helper.PaymentServiceHelper;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.request.PrepareData;
import com.siot.IamportRestClient.response.IamportResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private static final String PURCHASE_PREFIX = "purchase:";
    private static final String MEMBER_PREFIX = "member:";

    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final OutboxRepository outboxRepository;

    private final PaymentServiceHelper paymentServiceHelper;
    private final PaymentRepository paymentRepository;
    private final MemberRepository memberRepository;
    private final PurchasePaymentRepository purchasePaymentRepository;

    private IamportClient paymentExternalApi;
    private final ExternalPrePaymentApiRepository prePaymentApiRepository;

    @Value("${imp.api.key}")
    private String apiKey;

    @Value("${imp.api.apiSecret}")
    private String apiSecret;

    @PostConstruct
    public void init() {
        this.paymentExternalApi = new IamportClient(apiKey, apiSecret);
    }

    // Todo : 현재 사용 안함
    @Override
    @Transactional
    public void processPayment(List<String> purchaseIds, List<PurchaseCreatedEventAvroModel> messages) {

        for (String purchaseId : purchaseIds) {
            String PREFIX = purchaseId.split(":")[0];
            String purchaseKeyId = purchaseId.split(":")[1];
            log.info("purchaseKeyId = {}", purchaseKeyId);
            Purchase purchase = purchaseRepository.findById(Long.valueOf(purchaseKeyId))
                    .orElseThrow(() -> new PurchaseDomainException("해당 구매번호가 없습니다"));

            // Idempotency
            purchase.doReadyForPay();
            purchaseRepository.save(purchase);

            List<PurchaseProduct> orderedProducts = new ArrayList<>();
            // PaymentServiceHelper ...
            List<PurchaseCreatedEventAvroModel> collect = messages.stream().toList();
            for (PurchaseCreatedEventAvroModel purchaseCreatedEventAvroModel : collect) {

                List<PurchaseAvroModel> products = purchaseCreatedEventAvroModel.getProducts();
                for (PurchaseAvroModel productAvroModel : products) {
                    String productId = productAvroModel.getProductId();
                    PurchaseProduct purchaseProduct = purchaseProductRepository.findByProductIdAndPurchaseId(Long.valueOf(productId),
                                    Long.valueOf(purchaseKeyId))
                            .orElseThrow(() -> new PurchaseDomainException("주문 상품 내역이 존재하지 않습니다."));

                    log.info("주문상품 : {}, 상품 ID : {}", purchaseProduct.toString(), purchaseProduct.getProduct().getId());
                    orderedProducts.add(purchaseProduct);
                }
            }

            log.info("purchaseId, PREFIX : {}, VALUE : {}", PREFIX, purchaseKeyId);
        }
    }

    // Todo : 현재 사용 안함
    @Override
    @Transactional
    public void processAsyncPayment(PaymentCompleteRequest paymentCompleteRequest) {
        // 사용자가 결제 완료 후 사후 검증 메서드 구현 ...
//        String purchaseId = paymentCompleteRequest.getPurchaseId();
//        changedOutboxMessageForPreparePayment(purchaseId);
//
//        String aggregateId = modifyOutboxStatusToSendPaidEvent(purchaseId);
//        Optional<Purchase> purchase = purchaseRepository.findById(Long.valueOf(purchaseId));
//        createPaymentPaidOutboxMessage(aggregateId, purchase.get(), payment.getPaidAt(), payment.getTotalPrice());
    }

    private void changedOutboxMessageForPreparePayment(String purchaseId) {
        OutboxMessage outboxMessage = outboxRepository.findByAggregateId(PURCHASE_PREFIX + purchaseId)
                .orElseThrow(() -> new PurchaseDomainException("해당 하는 주문이 존재하지 않습니다."));
        outboxMessage.setStatus(OutboxStatus.PENDING);
        outboxRepository.save(outboxMessage);
    }

    // Todo : 현재 사용 안함
//    @Override
    @Transactional
    public void postValidateOrder(List<String> purchaseIds, List<PurchaseCreatedEventAvroModel> messages) {
        Purchase purchase = paymentServiceHelper.getPurchase(purchaseIds);
        int purchaseTotalPrice = purchase.getTotalPrice();

        int productTotalPrice = 0;

        List<PurchaseCreatedEventAvroModel> purchaseCreatedEventAvroModels = messages.stream().toList();
        for (PurchaseCreatedEventAvroModel purchaseCreatedEventAvroModel : purchaseCreatedEventAvroModels) {

            List<PurchaseAvroModel> avroProducts = purchaseCreatedEventAvroModel.getProducts();

            for (PurchaseAvroModel productAvroModel : avroProducts) {
                String productId = productAvroModel.getProductId();
                PurchaseProduct purchaseProduct = purchaseProductRepository.findByProductIdAndPurchaseId(Long.valueOf(productId),
                                purchase.getId())
                        .orElseThrow(() -> new PurchaseDomainException("주문 상품 내역이 존재하지 않습니다."));

                log.info("주문상품 : {}, 상품 ID : {}", purchaseProduct.toString(), purchaseProduct.getProduct().getId());

                productTotalPrice += purchaseProduct.getProduct().getPrice();
            }
        }

        if (productTotalPrice != purchaseTotalPrice) {
            throw new PurchaseDomainException("사전검증 결과 실패 : 상품 가격 총합과 총합이 맞지 않습니다.");
        }

        log.info("purchaseId : {}, 사전검증 통과", purchase.getId());
        purchase.doReadyForPay();
    }

    @Override
    @Transactional
    public void prepareForPost(ExternalPrePaymentReqDto externalPrePaymentReqDto) throws IamportResponseException, IOException {
        PrepareData prepareData =
                new PrepareData(externalPrePaymentReqDto.getMerchantUid(), externalPrePaymentReqDto.getAmount());

        paymentExternalApi.postPrepare(prepareData); // 사전 등록 API

        PrePaymentEntity prePaymentEntity = PrePaymentEntity.builder()
                .merchantUid(externalPrePaymentReqDto.getMerchantUid())
                .amount(externalPrePaymentReqDto.getAmount())
                .purchaseId(externalPrePaymentReqDto.getPurchaseId())
                .build();

        prePaymentApiRepository.save(prePaymentEntity);
    }

    @Override
    @Transactional
    public com.siot.IamportRestClient.response.Payment postValidateOrder(PaymentCompleteRequest paymentCompleteRequest) throws IamportResponseException, IOException {
        PrePaymentEntity prePayment = prePaymentApiRepository.findByMerchantUid(paymentCompleteRequest.getMerchantUid())
                .orElseThrow(() -> new PurchaseDomainException("외부결제 ID가 존재하지 않습니다"));
        BigDecimal preAmount = prePayment.getAmount(); // DB에 저장된 data

        IamportResponse<com.siot.IamportRestClient.response.Payment> iamportResponse =
                paymentExternalApi.paymentByImpUid(paymentCompleteRequest.getImpUid());

        BigDecimal paidAmount = iamportResponse.getResponse().getAmount(); // 실제 사용자가 결제한 금액

        log.info("preAmount : {}, paidAmount : {}", preAmount, paidAmount);
        // 데이터 포맷에 따른 오류가 발생 가능
        if (preAmount.intValue() != paidAmount.intValue()) {
            log.info("cancel payment in external payment API");
            CancelData cancelData = cancelPayment(iamportResponse);
            paymentExternalApi.cancelPaymentByImpUid(cancelData);
        }

        return iamportResponse.getResponse();
    }

    @Override
    @Transactional
    public void saveUserInfoForPayment(ExternalPaymentReqDto externalPaymentReqDto, String email) {

        log.info("externalPaymentReqDto {}", externalPaymentReqDto.toString());
//        기존 회원과 구매자의 배송지는 다를 수 있음
        Member member = memberRepository.findByEmail(email);

        Payment payment = Payment.builder()
                .member(member)
                .status(com.green.sahwang.entity.enumtype.PaymentStatus.valueOf(externalPaymentReqDto.getStatus().toUpperCase()))
                .systemLogicType(SystemLogicType.PURCHASE)
                .paymentType(PaymentType.CREDIT_CARD)
                .embPgProvider(externalPaymentReqDto.getEmbPgProvider())
                .paidAt(externalPaymentReqDto.getPaidAt())
                .impUid(externalPaymentReqDto.getImpUid())
                .pgProvider(externalPaymentReqDto.getPgProvider())
                .payMethod(externalPaymentReqDto.getPayMethod())
                .totalPrice(externalPaymentReqDto.getAmount().intValue())
                .merchantUid(externalPaymentReqDto.getMerchantUid())
                .build();

        paymentRepository.save(payment);
    }

    /**
     * 결제 완료 시 시스템 내 purchasePayment 저장 후
     * 카프카 이벤트 전송
     *
     * @param externalPurchasePaymentReqDto
     * @param email
     */
    @Override
    @Transactional
    public void savePurchaseInfoForPayment(ExternalPurchasePaymentReqDto externalPurchasePaymentReqDto, String email) {
        log.info("externalPurchasePaymentReqDto : {}", externalPurchasePaymentReqDto.toString());
        List<PurchaseProduct> purchaseProducts = purchaseProductRepository.findAllByProductIdIn(externalPurchasePaymentReqDto
                .getPurchaseProductDtos().stream()
                .map(purchaseProductReqDto -> purchaseProductReqDto.getProductId())
                .toList());

        Payment payment = paymentRepository.findByImpUid(externalPurchasePaymentReqDto.getImpUid())
                .orElseThrow(() -> new PaymentDomainException("해당 " + externalPurchasePaymentReqDto.getImpUid()
                        + " 외부결제가 존재하지 않습니다."));

        Purchase purchase = null;
        for (PurchaseProduct purchaseProduct : purchaseProducts) {
            PurchasePayment purchasePayment = PurchasePayment.builder()
                    .purchaseProduct(purchaseProduct)
                    .payment(payment)
                    .createdDate(payment.getPaidAt())
                    .build();
            purchasePaymentRepository.save(purchasePayment);

            purchase = purchaseProduct.getPurchase();
        }

        // 결제 완료
        purchase.setPurchaseStatus(PurchaseStatus.SHIP_READY);
        purchaseRepository.save(purchase);
        // 이벤트 준비
        createPaymentPaidOutboxMessage(purchase, payment, externalPurchasePaymentReqDto);
    }

    private CancelData cancelPayment(IamportResponse<com.siot.IamportRestClient.response.Payment>
                                       response) {
        return new CancelData(response.getResponse().getImpUid(), true);
    }

    // Todo : 현재 사용 안함
    private String modifyOutboxStatusToSendPaidEvent(String purchaseId) {
//        String aggregateId = PURCHASE_PREFIX + purchaseId;
//        OutboxMessage outboxMessage = outboxRepository.findByAggregateId(aggregateId)
//                .orElseThrow(() -> new PurchaseDomainException("No outbox purchase event"));
//        outboxMessage.setStatus(OutboxStatus.PENDING);
//        outboxRepository.save(outboxMessage);
//        return aggregateId;

        return null;
    }

    @Transactional
    private void createPaymentPaidOutboxMessage(Purchase purchase, Payment payment,
                                                  ExternalPurchasePaymentReqDto externalPurchasePaymentReqDto) {
        log.info("created purchaseId : {}", purchase.getId());
        log.info("purchase : {}", purchase.getPurchaseStatus());

        payment.setStatus(com.green.sahwang.entity.enumtype.PaymentStatus.COMPLETED);
        paymentRepository.save(payment);

        PurchasePaidEventAvroModel purchasePaidEventAvroModel = PurchasePaidEventAvroModel.newBuilder()
                .setPurchaseId(String.valueOf(purchase.getId()))
                .setMemberId(MEMBER_PREFIX + purchase.getMember().getId())
                .setPaymentStatus(PaymentStatus.valueOf(payment.getStatus().toString().toUpperCase()))
                .setPaymentMethod(PaymentMethod.CREDIT_CARD)
                .setTransactionId(payment.getImpUid())
                .setTimestamp(System.currentTimeMillis())
                .setAmount(payment.getTotalPrice())
                .setShippingAddress(externalPurchasePaymentReqDto.getBuyerPostcode()
                + " " + externalPurchasePaymentReqDto.getBuyerAddr())
                .build();

        log.info("purchasePaidEventAvroModel : {}", purchasePaidEventAvroModel.toString());

        OutboxMessage outboxMessage;
        try {
            outboxMessage = OutboxMessage.builder()
                    .aggregateId(PURCHASE_PREFIX + purchase.getId())
                    .avroModel(purchasePaidEventAvroModel.getClass().getName())
                    .eventType("Payment")
                    .topicName("payment-paid")
                    .payload(AvroToDBSerializer.serialize(purchasePaidEventAvroModel))
                    .sequenceNumber(System.currentTimeMillis())
                    .status(OutboxStatus.PENDING)
                    .createdAt(LocalDateTime.now())
                    .build();
        } catch (Exception e) {
            throw new OutboxSerializeEventException("Failed to serialize outboxMessage: " + e.getMessage());
        }

        outboxRepository.save(outboxMessage);
        log.info("outboxMessage = {}", outboxMessage);
    }
}
