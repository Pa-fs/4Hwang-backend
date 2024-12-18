package com.green.sahwang.service.impl;

import com.green.sahwang.dto.request.WishProductReqDto;
import com.green.sahwang.dto.response.WishCheckedResDto;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.WishCategory;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.WishCategoryRepository;
import com.green.sahwang.service.WishService;
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
    private final WishCategoryRepository wishCategoryRepository;

    @Transactional
    public List<WishCheckedResDto> getChecked(UserDetails userDetails, List<WishProductReqDto> wishProductReqDtoList){
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
    public Boolean clickWish(UserDetails userDetails, Long productId){
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

}
