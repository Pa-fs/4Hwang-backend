package com.green.sahwang.security.service;

import com.green.sahwang.security.filter.JWTUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService{

    private final JWTUtils jwtUtils;

    private final KakaoService kakaoService;

    public String remakeAccessTokenInJwt(String jwt){

        return null;
    }

    public String updateRefreshToken(){

        return null;
    }

}
