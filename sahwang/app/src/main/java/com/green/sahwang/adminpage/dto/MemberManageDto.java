package com.green.sahwang.adminpage.dto;

import com.green.sahwang.entity.enumtype.MemberRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class MemberManageDto {

    private Long memberId;

    private String profileImage;

    private String name;

    private String phoneNum;

    private String email;

    private MemberRole role;

    private LocalDateTime joinDate;

    private LocalDateTime withdrawDate;

    private LocalDateTime lastLoginDate;

    private String nickName;

    private int purchaseCount;

    private Boolean adReceived;

    private int warnCount;

    private int reviewCount;

}
