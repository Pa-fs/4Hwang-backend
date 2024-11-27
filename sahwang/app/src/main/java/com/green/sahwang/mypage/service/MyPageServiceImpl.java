package com.green.sahwang.mypage.service;

import com.green.sahwang.entity.*;
import com.green.sahwang.entity.enumtype.PurchaseStatus;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{

    private final MemberRepository memberRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseProductRepository purchaseProductRepository;
    private final PurchasePaymentRepository purchasePaymentRepository;
    private final SaleRepository saleRepository;
    private final WishRepository wishRepository;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final DeliveryPurchasesRepository deliveryPurchasesRepository;

    @Transactional(readOnly = true)
    public OrderProgressResDto getOrderProgress(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Purchase purchase = purchaseRepository.findTopByMemberAndStatusOrderByPurchaseDateDesc(member, true);

        OrderProgressResDto orderProgressResDto = new OrderProgressResDto();
        orderProgressResDto.setStatus(purchase.getPurchaseStatus());

        return orderProgressResDto;
    }

    @Transactional(readOnly = true)
    public SaleProgressResDto getSaleProgress(UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        Sale sale = saleRepository.findTopByMemberOrderBySaleStartDateDesc(member);

        SaleProgressResDto saleProgressResDto = new SaleProgressResDto();
        saleProgressResDto.setStatus(sale.getStatus());

        return saleProgressResDto;
    }

    @Transactional
    public List<OrderListResDto> getOrderList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Purchase> purchasePage = purchaseRepository.findAllByMember(member, pageable);

        List<Purchase> purchaseList = purchasePage.getContent();
        List<PurchaseProduct> purchaseProductList = purchaseProductRepository.findAllByPurchaseIn(purchaseList);
        List<DeliveryPurchase> deliveryPurchaseList = deliveryPurchasesRepository.findAllByPurchaseIn(purchaseList);

        return purchaseList.stream().map(purchase -> {
            OrderListResDto orderListResDto = new OrderListResDto();
            orderListResDto.setOrderDate(purchase.getPurchaseDate());
            orderListResDto.setOrderId(purchase.getId());
            LocalDateTime deliveredDate = deliveryPurchaseList.stream()
                    .filter(deliveryPurchase -> deliveryPurchase.getPurchase().getId().equals(purchase.getId()))
                    .map(DeliveryPurchase::getDeliveredDate)
                    .findFirst()
                    .orElse(null);
            orderListResDto.setDeliveredDate(deliveredDate);
            orderListResDto.setPurchaseStatus(purchase.getPurchaseStatus());
            List<OrderDetailResDto> orderDetailResDtoList = purchaseProductList.stream()
                    .filter(purchaseProduct -> purchaseProduct.getPurchase().getId().equals(purchase.getId()))
                    .map(purchaseProduct -> {
                        OrderDetailResDto orderDetailResDto = new OrderDetailResDto();
                        orderDetailResDto.setProductName(purchaseProduct.getProductName());
                        orderDetailResDto.setPrice(purchaseProduct.getProduct().getPrice());
                        orderDetailResDto.setQuantity(purchaseProduct.getProductQuantity());
                        return orderDetailResDto;
                    })
                    .toList();
            orderListResDto.setOrderDetailResDtoList(orderDetailResDtoList);
            return orderListResDto;
        }).toList();
    }

    @Transactional
    public List<SaleListResDto> getSaleList(UserDetails userDetails, int pageNum, int size){
        Member member = memberRepository.findByEmail(userDetails.getUsername());

        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Sale> salePage = saleRepository.findAllByMember(member, pageable);

        return null;
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
