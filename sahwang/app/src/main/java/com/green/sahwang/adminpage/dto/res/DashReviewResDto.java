package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.DashReviewListDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashReviewResDto {

    private List<DashReviewListDto> dashReviewListDtoList;

    private int reviewCount;

}
