package com.green.sahwang.security.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class JWTUtils {

    private String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz01234567890";
//
//    // JWT 생성
    public String createJWT(String email, String accessToken){
        String jwt = Jwts.builder()
                .claim("email",email)
                .claim("role","ROLE_USER")
                .claim("access_token", accessToken)
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
                .expiration(new Date(System.currentTimeMillis() + 1000)) // 1초 지나면 유효시간 없음...
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1초*60*60*24 1일 유효함
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()))
                .compact();
        return jwt;
    }

    public String createRefreshToken(String jwt){
        Claims claims = decodeJwt(jwt);

//        String subject = claims.getSubject(); // Extract the subject from the original JWT
//
//        String refreshToken = Jwts.builder()
//                .setSubject(subject) // Set the subject in the refresh token
//                .claim("email", claims.get("email"))
//                .claim("role", claims.get("role"))
//                .claim("access_token", claims.get("access_token"))
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
//                .signWith(SignatureAlgorithm.HS256,
//                        Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()))
//                .compact();

                String refreshToken = Jwts.builder()
                .claim("email", claims.get("email"))
                .claim("role", claims.get("role"))
                .claim("access_token", claims.get("access_token"))
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // 1초*60*60*24*7 7일 유효함
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()))
                .compact();

        return refreshToken;
    }

    public Claims decodeJwt(String jwt){
        SecretKey secretKey
                = new SecretKeySpec(SECRET_KEY.getBytes(),
                Jwts.SIG.HS256.key().build().getAlgorithm());
        Jws<Claims> claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(jwt);

        return claims.getPayload();
    }

    public String getEmailFromJwt(String jwt){
        Claims claims = decodeJwt(jwt);
        return claims.get("email").toString();
    }

    public String getAccessTokenFromJwt(String jwt){
        Claims claims = decodeJwt(jwt);
        return claims.get("access_token").toString();
    }

    public String getRoleFromJwt(String jwt){
        Claims claims = decodeJwt(jwt);
        return claims.get("role").toString();
    }
}
