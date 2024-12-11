package com.green.sahwang.repository;

import com.green.sahwang.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

//    public void get() {
//        jpaQueryFactory.select().from(QProduct.product).where();
//    }


}
