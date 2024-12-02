package com.green.sahwang.mypage.dto.req;

import com.green.sahwang.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberInfoReqDto {

    private String nickName;

    private Address address;

    private String name;

    private String phoneNum;

    private String email;

    private Boolean gender;

}
