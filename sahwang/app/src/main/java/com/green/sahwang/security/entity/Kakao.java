package com.green.sahwang.security.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Kakao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String profileImage;

    private String thumbnailImage;

    private String email;

    private String accessToken;

    private String tokenType;

    private String refreshToken;

    private String expiresIn;

    private String scope;

    private String refreshTokenExpiresIn;


}
