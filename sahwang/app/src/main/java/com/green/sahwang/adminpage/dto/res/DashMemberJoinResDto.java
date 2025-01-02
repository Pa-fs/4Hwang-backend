package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.DashMemberJoinListDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashMemberJoinResDto {

    private List<DashMemberJoinListDto> dashMemberListDtoJoinList;

    private int memberCount;

}
