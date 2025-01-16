package com.green.sahwang.security.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginReqDto {

    private String email;

    private String password;

}
