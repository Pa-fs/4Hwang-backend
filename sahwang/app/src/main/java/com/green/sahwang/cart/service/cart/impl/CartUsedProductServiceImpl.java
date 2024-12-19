package com.green.sahwang.cart.service.cart.impl;

import com.green.sahwang.cart.dto.request.ProductQuantityReqDto;
import com.green.sahwang.cart.dto.request.UsedProductQuantityReqDto;
import com.green.sahwang.cart.dto.response.CartUsedProductsResDto;
import com.green.sahwang.cart.entity.Cart;
import com.green.sahwang.cart.entity.CartUsedProduct;
import com.green.sahwang.cart.repository.CartRepository;
import com.green.sahwang.cart.repository.CartUsedProductRepository;
import com.green.sahwang.cart.service.cart.CartService;
import com.green.sahwang.cart.service.cart.CartUsedProductService;
import com.green.sahwang.entity.Member;
import com.green.sahwang.exception.*;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.service.impl.ProductServiceImpl;
import com.green.sahwang.usedproduct.dto.response.GeneralUsedProductResDto;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartUsedProductServiceImpl implements CartUsedProductService {
    private final CartUsedProductRepository cartUsedProductRepository;
    private final CartService cartService;
    private final UsedProductRepository usedProductRepository;
    private final ProductServiceImpl productService;
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public List<CartUsedProductsResDto> getUsedProductsInCart(String email) {
        Member member = getMemberForEmail(email);
        Cart cart = cartService.getCartForMember(member.getId());

        List<CartUsedProduct> cartUsedProducts = cartUsedProductRepository.findByCart(cart);

        return cartUsedProducts.stream()
                .map(cartUsedProduct -> {
                    UsedProduct usedProduct = usedProductRepository.findById(cartUsedProduct.getUsedProduct().getId())
                            .orElseThrow(() -> new BizException(ErrorCode.NO_USED_PRODUCT));

                    GeneralUsedProductResDto generalUsedProductResDto = productService.getUsedProductResDto(usedProduct);

                    return new CartUsedProductsResDto(generalUsedProductResDto, cartUsedProduct.getQuantity());
                }).toList();
    }

    @Override
    @Transactional
    public CartUsedProduct updateQuantity(Long cartProductId, int quantity) {
        CartUsedProduct cartUsedProduct = cartUsedProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductDomainException("장바구니제품이 존재하지 않습니다."));

        cartUsedProduct.setQuantity(quantity);
        return cartUsedProductRepository.save(cartUsedProduct);
    }

//    @Override
//    @Transactional
//    public void incrementQuantity(String email, ProductQuantityReqDto productQuantityReqDto) {
//
//        UsedProduct usedProduct = getUsedProduct(productQuantityReqDto.getProductId());
//        Member member = getMemberForEmail(email);
//        Cart cart = getCart(member);
//
//
//        CartUsedProduct cartUsedProduct = getCartUsedProduct(cart, usedProduct);
//
//        cartUsedProduct.setQuantity(cartUsedProduct.getQuantity() + productQuantityReqDto.getQuantity());
//        cartUsedProductRepository.save(cartUsedProduct);
//    }
    @Override
    @Transactional
    public void incrementQuantity(String email, UsedProductQuantityReqDto usedProductQuantityReqDto) {

        UsedProduct usedProduct = getUsedProduct(usedProductQuantityReqDto.getUsedProductId());
        Member member = getMemberForEmail(email);
        Cart cart = getCart(member);


        CartUsedProduct cartUsedProduct = getCartUsedProduct(cart, usedProduct);

        cartUsedProduct.setQuantity(cartUsedProduct.getQuantity() + usedProductQuantityReqDto.getQuantity());
        cartUsedProductRepository.save(cartUsedProduct);
    }

//    @Override
//    @Transactional
//    public void decrementQuantity(String email, ProductQuantityReqDto productQuantityReqDto) {
//        UsedProduct usedProduct = getUsedProduct(productQuantityReqDto.getProductId());
//        Member member = getMemberForEmail(email);
//        Cart cart = getCart(member);
//
//        CartUsedProduct cartUsedProduct = getCartUsedProduct(cart, usedProduct);
//
//        if(cartUsedProduct.getQuantity() - productQuantityReqDto.getQuantity() < 1) {
//            throw new CartProductDomainException("해당 제품 수량을 줄일 수 없습니다");
//        }
//        int newQuantity = cartUsedProduct.getQuantity() - productQuantityReqDto.getQuantity();
//        cartUsedProduct.setQuantity(newQuantity);
//
//        cartUsedProductRepository.save(cartUsedProduct);
//    }
    @Override
    @Transactional
    public void decrementQuantity(String email, UsedProductQuantityReqDto usedProductQuantityReqDto) {
        UsedProduct usedProduct = getUsedProduct(usedProductQuantityReqDto.getUsedProductId());
        Member member = getMemberForEmail(email);
        Cart cart = getCart(member);

        CartUsedProduct cartUsedProduct = getCartUsedProduct(cart, usedProduct);

        if(cartUsedProduct.getQuantity() - usedProductQuantityReqDto.getQuantity() < 1) {
            throw new CartProductDomainException("해당 제품 수량을 줄일 수 없습니다");
        }
        int newQuantity = cartUsedProduct.getQuantity() - usedProductQuantityReqDto.getQuantity();
        cartUsedProduct.setQuantity(newQuantity);

        cartUsedProductRepository.save(cartUsedProduct);
    }

    private UsedProduct getUsedProduct(Long productId) {
        return usedProductRepository.findById(productId)
                .orElseThrow(() -> new BizException(ErrorCode.NO_USED_PRODUCT));
    }

    private CartUsedProduct getCartUsedProduct(Cart cart, UsedProduct usedProduct) {
        return cartUsedProductRepository.findByCartAndUsedProduct(cart, usedProduct)
                .orElseThrow(() -> new BizException(ErrorCode.NO_USED_PRODUCT));
    }

    private Cart getCart(Member member) {
        return cartRepository.findByMember(member)
                .orElseThrow(() -> new CartDomainException("No cart"));
    }

    private Member getMember(ProductQuantityReqDto productQuantityReqDto) {
        return memberRepository.findById(productQuantityReqDto.getMemberId())
                .orElseThrow(() -> new DomainException("No member"));
    }

    private Member getMemberForEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
