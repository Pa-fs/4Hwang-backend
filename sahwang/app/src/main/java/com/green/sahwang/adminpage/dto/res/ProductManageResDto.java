package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.dto.response.ImageResDto;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductManageResDto {

    private Page<ProductManageDto> productManageDtos;

    private int productCount;

}
