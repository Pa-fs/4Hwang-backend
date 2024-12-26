package com.green.sahwang.verifiedsale.mapper;

import com.green.sahwang.verifiedsale.dto.response.SaleAcceptedListResDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface VerifiedSaleAcceptedMapper {

    List<SaleAcceptedListResDto> findVerifiedSaleAcceptedList(@Param("pageable") Pageable pageable);
}
