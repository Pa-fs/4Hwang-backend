package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.DashPendingListDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashPendingResDto {

    private List<DashPendingListDto> dashPendingListDtoList;

    private int pendingSaleCount;

}
