package com.green.sahwang.cart.service.cart.impl;

import com.green.sahwang.cart.dto.request.ProductQuantityReqDto;
import com.green.sahwang.dto.response.CartProductsResDto;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.cart.entity.Cart;
import com.green.sahwang.cart.entity.CartProduct;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.exception.CartDomainException;
import com.green.sahwang.exception.CartProductDomainException;
import com.green.sahwang.exception.DomainException;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.cart.repository.CartProductRepository;
import com.green.sahwang.cart.repository.CartRepository;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.cart.service.cart.CartProductService;
import com.green.sahwang.cart.service.cart.CartService;
import com.green.sahwang.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartProductServiceImpl implements CartProductService {
    private final CartProductRepository cartProductRepository;
    private final CartService cartService;
    private final ProductRepository productRepository;
    private final ProductServiceImpl productService;
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public List<CartProductsResDto> getProductsInCart(String email) {
        Member member = getMemberForEmail(email);
        Cart cart = cartService.getCartForMember(member.getId());

        List<CartProduct> cartProducts = cartProductRepository.findByCart(cart);

        return cartProducts.stream()
                .map(cartProduct -> {
                    Product product = productRepository.findById(cartProduct.getProduct().getId())
                            .orElseThrow(() -> new ProductDomainException("해당 제품이 존재하지 않습니다"));

                    ProductResDto productResDto = productService.getProductResDto(product);

                    return new CartProductsResDto(productResDto, cartProduct.getQuantity());
                }).toList();
    }

    @Override
    @Transactional
    public CartProduct updateQuantity(Long cartProductId, int quantity) {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductDomainException("장바구니제품이 존재하지 않습니다."));

        cartProduct.setQuantity(quantity);
        return cartProductRepository.save(cartProduct);
    }

    @Override
    @Transactional
    public void incrementQuantity(String email, ProductQuantityReqDto productQuantityReqDto) {

        Product product = getProduct(productQuantityReqDto.getProductId());
        Member member = getMemberForEmail(email);
        Cart cart = getCart(member);


        CartProduct cartProduct = getCartProduct(cart, product);

        cartProduct.setQuantity(cartProduct.getQuantity() + productQuantityReqDto.getQuantity());
        cartProductRepository.save(cartProduct);
    }

    @Override
    @Transactional
    public void decrementQuantity(String email, ProductQuantityReqDto productQuantityReqDto) {
        Product product = getProduct(productQuantityReqDto.getProductId());
        Member member = getMemberForEmail(email);
        Cart cart = getCart(member);

        CartProduct cartProduct = getCartProduct(cart, product);

        if(cartProduct.getQuantity() - productQuantityReqDto.getQuantity() < 1) {
            throw new CartProductDomainException("해당 제품 수량을 줄일 수 없습니다");
        }
        int newQuantity = cartProduct.getQuantity() - productQuantityReqDto.getQuantity();
        cartProduct.setQuantity(newQuantity);

        cartProductRepository.save(cartProduct);
    }

    private Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductDomainException("해당 제품ID : " + productId + "이 존재하지 않습니다"));
    }

    private CartProduct getCartProduct(Cart cart, Product product) {
        return cartProductRepository.findByCartAndProduct(cart, product)
                .orElseThrow(() -> new CartProductDomainException("장바구니제품이 존재하지 않습니다."));
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
