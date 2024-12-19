package com.green.sahwang.detail.dto.response;

import com.green.sahwang.detail.dto.DetailProductInfoDto;
import com.green.sahwang.dto.response.ImageResDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailProductInfoResDto {

    private DetailProductInfoDto detailProductInfoDto;
    private List<ImageResDto> productImage;

}
