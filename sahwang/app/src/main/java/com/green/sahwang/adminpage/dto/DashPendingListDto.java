package com.green.sahwang.adminpage.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashPendingListDto {

    private Long pendingSaleId;

    private String productName;

    private String CategoryName;

    private LocalDateTime createDate;

    private String nickName;

}
