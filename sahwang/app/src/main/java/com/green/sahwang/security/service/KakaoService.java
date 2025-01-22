package com.green.sahwang.security.service;

import com.green.sahwang.security.dto.LoginReqDto;

public interface KakaoService {
    String getToken(String code);
    String formLogin(LoginReqDto loginReqDto);
    void messageSend(String jwt, String message);
}
