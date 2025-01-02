package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.DashMemberLogInListDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashMemberLogInResDto {

    List<DashMemberLogInListDto> dashMemberLogInListDtoList;

    int memberCount;

}
