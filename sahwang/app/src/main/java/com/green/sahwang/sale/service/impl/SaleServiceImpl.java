package com.green.sahwang.sale.service.impl;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Sale;
import com.green.sahwang.entity.SaleProduct;
import com.green.sahwang.entity.enumtype.SaleStatus;
import com.green.sahwang.entity.product.Candle;
import com.green.sahwang.entity.product.Diffuser;
import com.green.sahwang.entity.product.Perfume;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.SaleProductRepository;
import com.green.sahwang.repository.SaleRepository;
import com.green.sahwang.sale.dto.SaleCreateReqDto;
import com.green.sahwang.sale.dto.SaleCreatedResDto;
import com.green.sahwang.sale.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleServiceImpl implements SaleService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final SaleProductRepository saleProductRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public SaleCreatedResDto createSale(SaleCreateReqDto saleCreateReqDto, String email) {

        // 상품 디비에서 전체 검색
        String productName = saleCreateReqDto.getProductName();
        String dtype = saleCreateReqDto.getDtype();
        List<Product> products = productRepository.findAllByName(productName);
        Member member = memberRepository.findByEmail(email);
        // 상품 없으면 상품 추가 등록
        if (products.isEmpty()) {
            Product noProduct = getNewProduct(saleCreateReqDto, dtype);

            productRepository.save(noProduct);

            saveSales(saleCreateReqDto, member, noProduct);
        } else {
            // 추후 수정
            saveSales(saleCreateReqDto, member, products.get(0));
        }

        Product product = productRepository.findByName(productName)
                .orElseThrow(() -> new BizException(ErrorCode.NO_PRODUCT));
        saleCreateReqDto.getImageFileReqDto().setProductId(product.getId());
        log.info("saleCreateReqDto.getImageFileReqDto = {}", saleCreateReqDto.getImageFileReqDto().toString());
        return null;
    }

    private void saveSales(SaleCreateReqDto saleCreatedDto, Member member, Product product) {
        // 판매 등록
        Sale sale = Sale.builder()
                .accepted(false)
                .status(SaleStatus.CREATED)
                .member(member)
                .expectedSellingPrice(saleCreatedDto.getExpectedSellingPrice())
                .build();
        saleRepository.save(sale);

        SaleProduct saleProduct = SaleProduct.builder()
                .product(product)
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
            default:
                noProduct = new Perfume();
                break;
        }
//            noProduct.setPrice();
        noProduct.setName(saleCreatedDto.getProductName());
        noProduct.setSize(saleCreatedDto.getSize());
//            noProduct.setBrand(saleCreatedDto.getBrandName());
        noProduct.setDtype(saleCreatedDto.getDtype());
        noProduct.setUsedOrNot(saleCreatedDto.isUsedOrNot());
        noProduct.setContent(saleCreatedDto.getContent());
        noProduct.setMainImage(null);
        return noProduct;
    }
}
