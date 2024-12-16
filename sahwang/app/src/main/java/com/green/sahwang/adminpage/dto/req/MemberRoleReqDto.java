package com.green.sahwang.adminpage.dto.req;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MemberRoleReqDto {

    private Long memberId;

    private String role;

}
