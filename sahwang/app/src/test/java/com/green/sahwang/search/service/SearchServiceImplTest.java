package com.green.sahwang.search.service;

import com.green.sahwang.dto.request.ProductDto;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.QProduct;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.green.sahwang.entity.QBrand.brand;
import static com.green.sahwang.entity.QProduct.product;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchServiceImplTest {

    @Autowired
    JPAQueryFactory queryFactory;

    @Test
    @Transactional
    public void test(){

        String keyword="Diptyque";

        // keyword에 따라 조건문 작성
        BooleanExpression productNameContainsKeyword = product.name.containsIgnoreCase(keyword);
        BooleanExpression brandNameContainsKeyword = brand.name.containsIgnoreCase(keyword);


        queryFactory
                .select(Projections.fields(
                            ProductDto.class,
                            product.name,
                            product.brand,
                            product.content,
                            product.adImage
                        ))
                .from(product)
                .join(product.brand, brand)
                .where(
                        product.brand.id.eq(brand.id)
                                .and(productNameContainsKeyword.or(brandNameContainsKeyword))
                )
                .fetch().stream().forEach(product1 -> System.out.println("product1 = " + product1));

//        List<Product> list = queryFactory
//                .selectFrom(product)
//                .join(product.brand, brand)
//                .where(
//                        product.brand.id.eq(brand.id)
//                                .and(productNameContainsKeyword.or(brandNameContainsKeyword))
//                )
//                .fetch();
//
//        System.out.println(list);
    }

}