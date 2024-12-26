package com.green.sahwang.verifiedsale.service;

import com.green.sahwang.verifiedsale.dto.response.SaleAcceptedListResDto;
import com.green.sahwang.verifiedsale.dto.response.SaleRejectionListResDto;

import java.util.List;

public interface VerifiedSaleService {

    List<SaleAcceptedListResDto> getVerifiedSaleAcceptedList(String email, int pageNum, int size, String sortType);

    List<SaleRejectionListResDto> getVerifiedSaleRejectionList(String email, int pageNum, int size, String sortType);
}
