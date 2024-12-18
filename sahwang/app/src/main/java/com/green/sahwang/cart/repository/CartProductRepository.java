package com.green.sahwang.cart.repository;

import com.green.sahwang.cart.entity.Cart;
import com.green.sahwang.cart.entity.CartProduct;
import com.green.sahwang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

    Optional<CartProduct> findByCartAndProduct(Cart cart, Product product);

    List<CartProduct> findByCart(Cart cart);

    List<CartProduct> findAllByProductIn(List<Product> products);

    void deleteAllByCart(Cart cart);

    void deleteAllByProductIdIn(List<Long> productIds);
}
