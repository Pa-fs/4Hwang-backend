package com.green.sahwang.mypage.service;

import com.green.sahwang.config.DateTimeUtils;
import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
import com.green.sahwang.exception.BizException;
import com.green.sahwang.exception.ErrorCode;
import com.green.sahwang.mypage.dto.res.*;
import com.green.sahwang.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{

    private final MemberRepository memberRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final SaleRepository saleRepository;
    private final WishRepository wishRepository;
    private final DeliveryPurchasesRepository deliveryPurchasesRepository;
    private final SaleProductRepository saleProductRepository;

    @Transactional
    public OrderProgressResDto getOrderProgress(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Purchase purchase = purchaseRepository.findTopByMemberAndStatusOrderByPurchaseDateDesc(member, true)
                .orElseThrow(() -> new BizException(ErrorCode.NO_PURCHASE));

        OrderProgressResDto orderProgressResDto = new OrderProgressResDto();
        orderProgressResDto.setStatus(purchase.getPurchaseStatus());

        return orderProgressResDto;
    }

    @Transactional(readOnly = true)
    public SaleProgressResDto getSaleProgress(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Sale sale = saleRepository.findTopByMemberOrderBySaleStartDateDesc(member)
                .orElseThrow(() -> new BizException(ErrorCode.NO_SALE));

        SaleProgressResDto saleProgressResDto = new SaleProgressResDto();
        saleProgressResDto.setStatus(sale.getStatus());

        return saleProgressResDto;
    }

    @Transactional
    public List<OrderListResDto> getOrderList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Purchase> purchasePage = purchaseRepository.findAllByMember(member, pageable);

        return purchasePage.stream().map(purchase -> {
            List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByPurchase(purchase);
            List<OrderDetailResDto> orderDetailResDtoList = purchaseProductList.stream().map(purchaseProduct -> {
                DeliveryPurchase deliveryPurchase = deliveryPurchasesRepository.findByPurchaseProduct(purchaseProduct);
                return new OrderDetailResDto(
                        deliveryPurchase != null ? deliveryPurchase.getDeliveredDate() : null,
                        purchaseProduct.getProductName(),
                        purchaseProduct.getProduct().getPrice() * purchaseProduct.getProductQuantity(),
                        purchaseProduct.getProductQuantity()
                );
            }).toList();
            return new OrderListResDto(
                    purchase.getPurchaseDate(),
                    purchase.getId().toString() + "-" + DateTimeUtils.formatOrderNumber(purchase.getPurchaseDate()),
                    purchase.getPurchaseStatus(),
                    orderDetailResDtoList
            );
        }).toList();
    }

    @Transactional
    public List<SaleListResDto> getSaleList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Sale> salePage = saleRepository.findAllByMember(member, pageable);

        return salePage.stream().map(sale -> {
            List<SaleProduct> saleProductList = saleProductRepository.findAllBySale(sale);
            List<SaleDetailResDto> saleDetailResDtoList = saleProductList.stream().map(saleProduct -> {
                return new SaleDetailResDto(
                        saleProduct.getTradeCompletedDate(),
                        saleProduct.getProduct().getName(),
                        saleProduct.getTradePrice(),
                        saleProduct.getQuantity()
                );
            }).toList();
            return new SaleListResDto(
                    sale.getSaleStartDate(),
                    sale.getId().toString() + "-" + DateTimeUtils.formatOrderNumber(sale.getSaleStartDate()),
                    sale.getStatus(),
                    saleDetailResDtoList
            );
        }).toList();
    }

    @Transactional(readOnly = true)
    public List<WishListResDto> getWishList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Wish> wishPage = wishRepository.findAllByMemberAndIsChecked(member, true, pageable);

        List<WishListResDto> wishListResDtoList = new ArrayList<>();

        for(Wish wish : wishPage){
            WishListResDto wishListResDto = new WishListResDto();
            wishListResDto.setProductName(wish.getProduct().getName());
            wishListResDto.setProductPrice(wish.getProduct().getPrice());
            wishListResDto.setSize(wishListResDto.getSize());
            wishListResDto.setMainImage(wish.getProduct().getMainImage());
            wishListResDtoList.add(wishListResDto);
        }

        return wishListResDtoList;
    }



}
