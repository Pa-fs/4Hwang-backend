package com.green.sahwang.cart.service.cart.impl;

import com.green.sahwang.cart.dto.request.CartUsedProductRemoveReqDto;
import com.green.sahwang.cart.dto.request.CartUsedProductReqDto;
import com.green.sahwang.cart.entity.Cart;
import com.green.sahwang.cart.entity.CartUsedProduct;
import com.green.sahwang.cart.repository.CartRepository;
import com.green.sahwang.cart.repository.CartUsedProductRepository;
import com.green.sahwang.entity.*;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.CartDomainException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.exception.payment.PaymentDomainException;
import com.green.sahwang.model.payment.avro.PurchasePaidEventAvroModel;
import com.green.sahwang.repository.*;
import com.green.sahwang.cart.service.cart.CartService;
import com.green.sahwang.cart.service.cart.helper.CartServiceHelper;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    private final UsedProductRepository usedProductRepository;
    private final CartUsedProductRepository cartUsedProductRepository;
    private final CartServiceHelper cartServiceHelper;
    private final PaymentRepository paymentRepository;
    private final PurchasePaymentRepository purchasePaymentRepository;

    @Override
    @Transactional
    public Cart getCartForMember(Long memberId) {
        Member member = getMemberById(memberId);
        return cartRepository.findByMember(member)
                .orElseGet(() -> createNewCartForMember(member));
    }

    @Override
    @Transactional
    public void addUsedProductToCart(String email, Long usedProductId, int quantity) {
        Member member = getMemberByEmail(email);

        Cart cart = cartRepository.findByMember(member)
                .orElseGet(() -> createNewCartForMember(member));

        UsedProduct usedProduct = getUsedProduct(usedProductId);

        CartUsedProduct cartUsedProduct = cartUsedProductRepository.findByCartAndUsedProduct(cart, usedProduct)
                .orElse(null);

        if (cartUsedProduct == null) {
            cartUsedProduct = CartUsedProduct.builder()
                    .cart(cart)
                    .usedProduct(usedProduct)
                    .quantity(quantity)
                    .build();
        } else {
            // 이미 있으면 더함
            // 수량 1로 고정
            cartUsedProduct.setQuantity(1);
        }
        cartUsedProductRepository.save(cartUsedProduct);
    }

    @Override
    @Transactional
    public void removeUsedProductFromCart(String email, List<CartUsedProductRemoveReqDto> cartUsedProductRemoveReqDtos) {
        List<UsedProduct> usedProducts = cartUsedProductRemoveReqDtos.stream()
                .map(cartProductsRemoveReqDto -> usedProductRepository.findById(cartProductsRemoveReqDto.getUsedProductId())
                        .orElseThrow(() -> new BizException(ErrorCode.NO_USED_PRODUCT))).toList();

        Member member = getMemberByEmail(email);
        Cart cart = cartRepository.findByMember(member)
                .orElseThrow(() -> new CartDomainException("No cart"));

        List<CartUsedProduct> cartUsedProducts = cartUsedProductRepository.findAllByUsedProductIn(usedProducts)
                .stream()
                .filter(cartUsedProduct -> cartUsedProduct.getCart().equals(cart)) // 특정 카트에 해당하는 것만 필터링
                .collect(Collectors.toList());
        cartUsedProductRepository.deleteAll(cartUsedProducts);
    }

    @Override
    @Transactional
    public void mergeUsedProductsInCartWithUserLogin(List<CartUsedProductReqDto> cartUsedProductReqDtos, String userEmail) {
        Member member = getMemberByEmail(userEmail);
        Cart cart = getCartForMember(member.getId());

        List<CartUsedProduct> localUsedProducts = cartServiceHelper.getLocalUsedProducts(cart, cartUsedProductReqDtos);

        List<CartUsedProduct> existingUsedProducts = cartUsedProductRepository.findByCart(cart);

        for (CartUsedProduct localUsedProduct : localUsedProducts) {
            CartUsedProduct existingCartUsedProduct = existingUsedProducts.stream()
                    .filter(cartUsedProduct -> cartUsedProduct.getUsedProduct().getId().equals(localUsedProduct.getUsedProduct().getId()))
                    .findFirst()
                    .orElse(null);


            // 재고수량은 뺐기 때문에 항상 수량은 1로 고정
            if (existingCartUsedProduct != null) {
//                existingCartUsedProduct.setQuantity(existingCartUsedProduct.getQuantity() + localUsedProduct.getQuantity());
                existingCartUsedProduct.setQuantity(1);
                cartUsedProductRepository.save(existingCartUsedProduct);
            } else {
                UsedProduct usedProduct = getUsedProduct(localUsedProduct.getUsedProduct().getId());
                CartUsedProduct cartUsedProduct = CartUsedProduct.builder()
                        .cart(cart)
                        .usedProduct(usedProduct)
                        .quantity(localUsedProduct.getQuantity())
                        .build();
                cartUsedProductRepository.save(cartUsedProduct);
            }
        }
    }

    @Override
    @Transactional
    public void clearCart(List<String> keys, List<PurchasePaidEventAvroModel> messages) {
        log.info("after paid, clear cart");
        Payment payment = null;
        List<PurchasePaidEventAvroModel> purchasePaidEventAvroModels = messages.stream().toList();
        for (PurchasePaidEventAvroModel purchasePaidEventAvroModel : purchasePaidEventAvroModels) {
            payment = paymentRepository.findByImpUid(purchasePaidEventAvroModel.getTransactionId())
                    .orElseThrow(() -> new PaymentDomainException("No Payment TransactionId"));

            log.info("paymentId : {}, status : {}", payment.getId(), payment.getStatus());
            payment.validatePaidCompletedStatus();

            // 결제된 중고제품 ID만 제거해야함
            // paymentId -> purchasePayments -> purchaseProduct -> usedProductIds
            List<PurchasePayment> purchasePayments = purchasePaymentRepository.findAllByPayment(payment);
            cartUsedProductRepository.deleteAllByUsedProductIdIn(purchasePayments.stream()
                    .map(purchasePayment -> purchasePayment.getPurchaseProduct().getUsedProduct().getId())
                    .toList());
        }
    }

    private Cart createNewCartForMember(Member member) {
        Cart cart = new Cart();
        cart.setMember(member);
        return cartRepository.save(cart);
    }

    private Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new CartDomainException("memberId " + memberId + " 해당 사용자가 존재하지 않습니다."));
    }

    private Member getMemberByEmail(String userEmail) {
        return memberRepository.findByEmail(userEmail);
    }

    private UsedProduct getUsedProduct(Long usedProductId) {
        return usedProductRepository.findById(usedProductId)
                .orElseThrow(() -> new BizException(ErrorCode.NO_USED_PRODUCT));
    }
}
