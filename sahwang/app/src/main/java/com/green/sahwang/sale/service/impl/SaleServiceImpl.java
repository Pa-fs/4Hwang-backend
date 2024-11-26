package com.green.sahwang.sale.service.impl;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Sale;
import com.green.sahwang.entity.SaleProduct;
import com.green.sahwang.entity.enumtype.SaleStatus;
import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.entity.product.Diffuser;
import com.green.sahwang.entity.product.Perfume;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.SaleProductRepository;
import com.green.sahwang.repository.SaleRepository;
import com.green.sahwang.sale.dto.SaleCreateReqDto;
import com.green.sahwang.sale.dto.SaleCreatedResDto;
import com.green.sahwang.sale.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final SaleProductRepository saleProductRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public SaleCreatedResDto createSale(SaleCreateReqDto saleCreatedDto, String email) {

        // 상품 디비에서 전체 검색
        String productName = saleCreatedDto.getProductName();
        String dtype = saleCreatedDto.getDtype();
        List<Product> products = productRepository.findAllByName(productName);
        Member member = memberRepository.findByEmail(email);
        // 상품 없으면 상품 추가 등록
        if (products.isEmpty()) {
            Product noProduct = getNewProduct(saleCreatedDto, dtype);

            productRepository.save(noProduct);

            saveSales(saleCreatedDto, member, noProduct);
        } else {
            // 추후 수정
            saveSales(saleCreatedDto, member, products.get(0));
        }

        return null;
    }

    private void saveSales(SaleCreateReqDto saleCreatedDto, Member member, Product noProduct) {
        // 판매 등록
        Sale sale = Sale.builder()
                .accepted(false)
                .status(SaleStatus.CREATED)
                .member(member)
                .expectedSellingPrice(saleCreatedDto.getExpectedSellingPrice())
                .build();
        saleRepository.save(sale);

        SaleProduct saleProduct = SaleProduct.builder()
                .product(noProduct)
                .sale(sale)
                .build();
        saleProductRepository.save(saleProduct);
    }

    private static Product getNewProduct(SaleCreateReqDto saleCreatedDto, String dtype) {
        Product noProduct = null;
        switch (dtype) {
            case "P":
                noProduct = new Perfume();
                break;
            case "D":
                noProduct = new Diffuser();
                break;
            case "C":
                noProduct = new Candle();
                break;
        }
//            noProduct.setPrice();
        noProduct.setName(saleCreatedDto.getProductName());
        noProduct.setSize(saleCreatedDto.getSize());
//            noProduct.setBrand(saleCreatedDto.getBrandName());
        noProduct.setDtype(saleCreatedDto.getDtype());
        noProduct.setUsedOrNot(saleCreatedDto.isUsedOrNot());
        return noProduct;
    }
}
