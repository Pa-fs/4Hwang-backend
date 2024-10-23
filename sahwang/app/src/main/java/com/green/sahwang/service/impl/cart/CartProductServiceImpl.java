package com.green.sahwang.service.impl.cart;

import com.green.sahwang.dto.response.CartProductsResDto;
import com.green.sahwang.dto.response.ImageResDto;
import com.green.sahwang.dto.response.ProductResDto;
import com.green.sahwang.entity.Cart;
import com.green.sahwang.entity.CartProduct;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.ProductImage;
import com.green.sahwang.exception.CartProductDomainException;
import com.green.sahwang.exception.ProductDomainException;
import com.green.sahwang.repository.CartProductRepository;
import com.green.sahwang.repository.ProductImageRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.service.ReviewService;
import com.green.sahwang.service.cart.CartProductService;
import com.green.sahwang.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartProductServiceImpl implements CartProductService {
    private final CartProductRepository cartProductRepository;
    private final CartService cartService;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ReviewService reviewService;

    @Override
    @Transactional
    public List<CartProductsResDto> getProductsInCart(Long memberId) {
        Cart cart = cartService.getCartForMember(memberId);

        List<CartProduct> cartProducts = cartProductRepository.findByCart(cart);

        return cartProducts.stream()
                .map(cartProduct -> {
                    Product product = productRepository.findById(cartProduct.getProduct().getId())
                            .orElseThrow(() -> new ProductDomainException("해당 제품이 존재하지 않습니다"));

                    List<ProductImage> productImages = productImageRepository.findByProduct(product);
                    List<ImageResDto> imageResponses = productImages.stream()
                            .map(image -> new ImageResDto(image.getFilename(), image.getPath(), image.getFileDesc()))
                            .toList();

                    ProductResDto productResDto = new ProductResDto(product.getId(),
                            product.getName(),
                            product.getContent(),
                            product.getDtype(),
                            product.getBrand().getName(),
                            product.getPrice(),
                            reviewService.reviewCount(product),
                            imageResponses);

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
    public CartProduct incrementQuantity(Long cartProductId, int incrementValue) {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductDomainException("장바구니제품이 존재하지 않습니다."));

        cartProduct.setQuantity(cartProduct.getQuantity() + incrementValue);
        return cartProductRepository.save(cartProduct);
    }

    @Override
    @Transactional
    public CartProduct decrementQuantity(Long cartProductId, int decrementValue) {
        CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                .orElseThrow(() -> new CartProductDomainException("장바구니제품이 존재하지 않습니다."));

        if(cartProduct.getQuantity() - decrementValue < 1) {
            throw new CartProductDomainException("해당 제품 수량을 줄일 수 없습니다");
        }
        int newQuantity = cartProduct.getQuantity() - decrementValue;
        cartProduct.setQuantity(newQuantity);

        return cartProductRepository.save(cartProduct);
    }
}
