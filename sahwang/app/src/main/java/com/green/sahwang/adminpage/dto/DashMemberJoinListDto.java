package com.green.sahwang.adminpage.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashMemberJoinListDto {

    private Long memberId;

    private String nickName;

    private String email;

    private LocalDateTime joinDate;

}
