package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.entity.enumtype.SaleStatus;
import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.entity.product.Perfume;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.SaleProductRepository;
import com.green.sahwang.repository.SaleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
class SaleTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SaleProductRepository saleProductRepository;

    @BeforeEach
    void setUp() {
        Member member = new Member();
        member.setName("test1");
        member.setRole(MemberRole.SELLER);
        memberRepository.save(member);

        Candle product1 = new Candle();
        product1.setName("candle1");
        product1.setPrice(10000);

        Perfume product2 = new Perfume();
        product2.setName("perfume1");
        product2.setPrice(20000);

        productRepository.save(product1);
        productRepository.save(product2);
    }

    @Test
    @DisplayName("판매 엔티티 테스트")
    void testSaleEntity() {
        Sale sale1 = new Sale();
        Sale sale2 = new Sale();

        Member member = memberRepository.findAll().get(0);

        log.info("member.getId() : {}", member.getId());
        sale1.setMember(member);
        sale2.setMember(member);

        assertThat(sale1.getMember().getId()).isEqualTo(member.getId());
        assertThat(sale2.getMember().getId()).isEqualTo(member.getId());
    }

    @Test
    @DisplayName("판매 테스트(서비스 계층 X)")
    void testSellingWithoutService() {
        Sale sale = new Sale();
        sale.setExpectedSellingPrice(30000);
        sale.setStatus(SaleStatus.LISTED);
        sale.setAccepted(true);
        sale.setMember(memberRepository.findById(1L).orElse(null));
        saleRepository.save(sale);

        // 구매 후
        Member purchaseMember = new Member();
        int productTotalPrice = 0;
        List<Product> products = productRepository.findAll();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            productTotalPrice += product.getPrice();
            log.info("product price : {}", products.get(i).getPrice());

            SaleProduct saleProduct = new SaleProduct();
            saleProduct.setProduct(product);
            saleProduct.setTradePrice(product.getPrice());
            saleProduct.setTradeCompletedDate(LocalDateTime.now());
            saleProduct.setSale(sale);

            sale.setStatus(SaleStatus.READY);
            saleProductRepository.save(saleProduct);
        }

        log.info("saleProduct size() : {}", saleProductRepository.findAll().size());
        log.info("product total price : {}", productTotalPrice);

        int expectedPrice = 0;
        List<SaleProduct> list = saleProductRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            expectedPrice += list.get(i).getTradePrice();
            assertThat(list.get(i).getSale().getId()).isEqualTo(sale.getId());
        }

        assertThat(productTotalPrice).isEqualTo(expectedPrice);
    }
}