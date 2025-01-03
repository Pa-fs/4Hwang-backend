package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.DashOrderListDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashOrderResDto {

    private List<DashOrderListDto> dashOrderListDtoList;

    private int orderCount;

}
