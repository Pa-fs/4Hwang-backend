package com.green.sahwang.security.service;

public interface KakaoService {
    String getToken(String code);
    void messageSend(String jwt, String message);
}
