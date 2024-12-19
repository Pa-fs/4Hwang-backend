package com.green.sahwang.cart.repository;

import com.green.sahwang.cart.entity.Cart;
import com.green.sahwang.cart.entity.CartUsedProduct;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartUsedProductRepository extends JpaRepository<CartUsedProduct, Long> {

    Optional<CartUsedProduct> findByCartAndUsedProduct(Cart cart, UsedProduct usedProduct);

    List<CartUsedProduct> findByCart(Cart cart);

    List<CartUsedProduct> findAllByUsedProductIn(List<UsedProduct> usedProducts);

    void deleteAllByCart(Cart cart);

    void deleteAllByUsedProductIdIn(List<Long> UsedProductIds);
}
