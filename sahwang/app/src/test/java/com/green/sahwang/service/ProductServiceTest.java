package com.green.sahwang.service;

import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.entity.product.Diffuser;
import com.green.sahwang.entity.product.Perfume;
import com.green.sahwang.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    @Transactional
    void productServiceTest(){
        Candle candle = new Candle();
        candle.setName("초111");
        candle.setBurningTime(20);

        productRepository.save(candle);

        Diffuser diffuser = new Diffuser();
        diffuser.setName("퓨저");
        diffuser.setAccessory("짝대기");

        productRepository.save(diffuser);

        Perfume perfume = new Perfume();
        perfume.setName("향수");
        perfume.setGender(true);

        productRepository.save(perfume);

        List<Product> diffusers = productRepository.findAllByDtype("D");

        assertThat(diffusers.get(0).getName()).isEqualTo(diffuser.getName());


//        List<Product> productList = productService.productList();
//        System.out.println(productList);
//
//        assertThat(productRepository).isNotNull();
//        assertThat(productList.get(0).getName()).isEqualTo(productRepository.findById(candle.getId()).orElse(null).getName());
//        assertThat(productList.get(1).getName()).isEqualTo(productRepository.findById(diffuser.getId()).orElse(null).getName());
//        assertThat(productList.get(2).getName()).isEqualTo(productRepository.findById(perfume.getId()).orElse(null).getName());

    }
}