package com.green.sahwang.entity;

import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.entity.product.Perfume;
import com.green.sahwang.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductInheritanceTest {

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        Perfume perfume = new Perfume();
        perfume.setName("perfume1");
        Candle candle = new Candle();
        candle.setName("candle1");

        productRepository.save(perfume);
        productRepository.save(candle);
    }

    @Test
    @DisplayName("상품 상속매핑 테스트")
    void testProductEntity() {
        List<Product> products = productRepository.findAll();

        assertThat(products.size()).isEqualTo(2);
    }
}