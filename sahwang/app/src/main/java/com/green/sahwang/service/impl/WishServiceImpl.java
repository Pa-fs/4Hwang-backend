package com.green.sahwang.service.impl;

import com.green.sahwang.dto.request.WishProductReqDto;
import com.green.sahwang.dto.response.WishCheckedResDto;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.WishCategory;
import com.green.sahwang.entity.WishProduct;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.WishCategoryRepository;
import com.green.sahwang.repository.WishProductRepository;
import com.green.sahwang.service.WishService;
import com.green.sahwang.usedproduct.entity.UsedProduct;
import com.green.sahwang.usedproduct.repository.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishServiceImpl implements WishService {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final UsedProductRepository usedProductRepository;
    private final WishCategoryRepository wishCategoryRepository;
    private final WishProductRepository wishProductRepository;

    @Transactional
    public List<WishCheckedResDto> getCheckedCategory(UserDetails userDetails, List<WishProductReqDto> wishProductReqDtoList){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        List<Long> productIdlist = wishProductReqDtoList.stream()
                .map(WishProductReqDto::getProductId)
                .toList();

        List<Product> productList = productRepository.findAllById(productIdlist);

        List<WishCategory> wishCategoryList = wishCategoryRepository.findAllByProductInAndMember(productList, member);

        Map<Long, WishCategory> wishMap = wishCategoryList.stream()
                .collect(Collectors.toMap(wishCategory -> wishCategory.getProduct().getId(), wishCategory -> wishCategory));

        List<WishCheckedResDto> wishCheckedResDtoList = new ArrayList<>();

        for (Product product : productList){
            WishCheckedResDto wishCheckedResDto = new WishCheckedResDto();
            wishCheckedResDto.setProductId(product.getId());
            wishCheckedResDto.setChecked(wishMap.containsKey(product.getId()));
            wishCheckedResDtoList.add(wishCheckedResDto);
        }

        return wishCheckedResDtoList;
    }

    @Transactional
    public List<WishCheckedResDto> getCheckedProduct(UserDetails userDetails, List<WishProductReqDto> wishProductReqDtoList){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        List<Long> productIdlist = wishProductReqDtoList.stream()
                .map(WishProductReqDto::getProductId)
                .toList();

        List<UsedProduct> usedProductList = usedProductRepository.findAllById(productIdlist);

        List<WishProduct> wishProductList = wishProductRepository.findAllByUsedProductInAndMember(usedProductList, member);

        Map<Long, WishProduct> wishMap = wishProductList.stream()
                .collect(Collectors.toMap(WishProduct -> WishProduct.getUsedProduct().getId(), wishProduct -> wishProduct));

        List<WishCheckedResDto> wishCheckedResDtoList = new ArrayList<>();

        for (UsedProduct usedProduct : usedProductList){
            WishCheckedResDto wishCheckedResDto = new WishCheckedResDto();
            wishCheckedResDto.setProductId(usedProduct.getId());
            wishCheckedResDto.setChecked(wishMap.containsKey(usedProduct.getId()));
            wishCheckedResDtoList.add(wishCheckedResDto);
        }

        return wishCheckedResDtoList;
    }

    @Transactional
    public Boolean clickWishCategory(UserDetails userDetails, Long productId){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Product product = productRepository.findById(productId).orElseThrow();
        WishCategory wishCategory = wishCategoryRepository.findByProductAndMember(product, member);

        if (wishCategory == null){
            wishCategory = new WishCategory();
            wishCategory.setProduct(product);
            wishCategory.setMember(member);
            wishCategory.setIsChecked(true);
        } else {
            wishCategory.setIsChecked(!wishCategory.getIsChecked());
        }

        wishCategoryRepository.save(wishCategory);
        log.info("wish : {}", wishCategory);
        return wishCategory.getIsChecked();
    }

    @Transactional
    public Boolean clickWishProduct(UserDetails userDetails, Long productId){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        UsedProduct usedProduct = usedProductRepository.findById(productId).orElseThrow();
        WishProduct wishProduct = wishProductRepository.findByMemberAndUsedProduct(member, usedProduct);

        if (wishProduct == null){
            wishProduct = new WishProduct();
            wishProduct.setUsedProduct(usedProduct);
            wishProduct.setMember(member);
            wishProduct.setIsChecked(true);
        }else {
            wishProduct.setIsChecked(!wishProduct.getIsChecked());
        }

        wishProductRepository.save(wishProduct);
        return wishProduct.getIsChecked();
    }

}
