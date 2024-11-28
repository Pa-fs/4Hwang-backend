package com.green.sahwang.mypage.dto.req;

import com.green.sahwang.entity.Address;
import lombok.Data;

@Data
public class MemberInfoReqDto {

    String nickName;
    Address address;
    String name;
    String phoneNum;
    String email;
    Boolean gender;

}
