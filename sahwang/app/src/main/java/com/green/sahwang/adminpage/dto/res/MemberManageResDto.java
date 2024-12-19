package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.MemberManageDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberManageResDto {

    private List<MemberManageDto> memberManageDtos;
    private Long memberId;

    private String profileImage;

    private String name;

    private String phoneNum;

    private String email;

    private MemberRole role;

    private int memberCount;

}
