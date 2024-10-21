package com.green.sahwang.repository;

import com.green.sahwang.entity.Cart;
import com.green.sahwang.entity.CartProduct;
import com.green.sahwang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

    Optional<CartProduct> findByCartAndProduct(Cart cart, Product product);

    void deleteAllByCart(Cart cart);
}
