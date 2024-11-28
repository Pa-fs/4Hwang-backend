package com.green.sahwang.mypage.dto.res;

import com.green.sahwang.entity.Address;
import lombok.Data;

@Data
public class MemberInfoResDto {

    String nickName;
    Address address;
    String name;
    String phoneNum;
    String email;
    Boolean gender;

}
