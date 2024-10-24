package com.green.sahwang.service.impl.cart;

import com.green.sahwang.dto.request.TestCartProductsReqDto;
import com.green.sahwang.entity.Cart;
import com.green.sahwang.entity.CartProduct;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.exception.CartDomainException;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.repository.CartProductRepository;
import com.green.sahwang.repository.CartRepository;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final CartProductRepository cartProductRepository;

    @Override
    public Cart getCartForMember(Long memberId) {
        Member member = getMemberById(memberId);
        return cartRepository.findByMember(member)
                .orElseGet(() -> createNewCartForMember(member));
    }

    @Override
    @Transactional
    public Cart addProductToCart(Long memberId, Long productId, int quantity) {
        Member member = getMemberById(memberId);

        Cart cart = cartRepository.findByMember(member)
                .orElseGet(() -> createNewCartForMember(member));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductDomainException("productId " + productId + " 해당 제품이 존재하지 않습니다"));


        CartProduct cartProduct = cartProductRepository.findByCartAndProduct(cart, product)
                .orElse(null);

        if (cartProduct == null) {
            cartProduct = CartProduct.builder()
                    .cart(cart)
                    .product(product)
                    .quantity(quantity)
                    .build();
        } else {
            // 이미 있으면 더함
            cartProduct.setQuantity(cartProduct.getQuantity() + quantity);
        }
        cartProductRepository.save(cartProduct);
        return cart;
    }

    @Override
    @Transactional
    public void clearCart(Long memberId) {
        Member member = getMemberById(memberId);
        Cart cart = cartRepository.findByMember(member)
                .orElseThrow(() -> new CartDomainException("해당 회원의 장바구니를 찾을 수 없습니다"));

        cartProductRepository.deleteAllByCart(cart);
    }

    @Override
    @Transactional
    public void removeProductFromCart(List<TestCartProductsReqDto> cartProductsReqDtos) {
        List<Product> products = cartProductsReqDtos.stream()
                .map(cartProductsReqDto -> productRepository.findById(cartProductsReqDto.getProductId())
                        .orElseThrow(() -> new ProductDomainException("productId " + cartProductsReqDto.getProductId() + " 해당 제품이 존재하지 않습니다"))).toList();

        List<CartProduct> cartProducts = cartProductRepository.findAllByProductIn(products);
        cartProductRepository.deleteAll(cartProducts);
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
}
