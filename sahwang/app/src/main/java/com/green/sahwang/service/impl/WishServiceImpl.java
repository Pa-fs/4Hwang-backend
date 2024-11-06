package com.green.sahwang.service.impl;

import com.green.sahwang.dto.request.WishProductReqDto;
import com.green.sahwang.dto.response.WishCheckedResDto;
import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Product;
import com.green.sahwang.entity.Wish;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.ProductRepository;
import com.green.sahwang.repository.WishRepository;
import com.green.sahwang.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishServiceImpl implements WishService {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final WishRepository wishRepository;

    @Transactional
    public List<WishCheckedResDto> getChecked(UserDetails userDetails, List<WishProductReqDto> wishProductReqDtoList){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        List<Long> productIdlist = wishProductReqDtoList.stream()
                .map(WishProductReqDto::getProductId)
                .toList();

        List<Product> productList = productRepository.findAllById(productIdlist);

        List<Wish> wishList = wishRepository.findAllByProductInAndMember(productList, member);

        Map<Long, Wish> wishMap = wishList.stream()
                .collect(Collectors.toMap(wish -> wish.getProduct().getId(), wish -> wish));

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
        Wish wish = wishRepository.findByProductAndMember(product, member);

        if (wish == null){
            wish = new Wish();
            wish.setProduct(product);
            wish.setMember(member);
            wish.setCheckOrNot(true);
        } else {
            wish.setCheckOrNot(!wish.getCheckOrNot());
        }

        wishRepository.save(wish);
        return wish.getCheckOrNot();
    }

}
