package com.green.sahwang.security.filter;

import com.green.sahwang.entity.enumtype.MemberRole;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class JWTUtils {

    private static final String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz01234567890";
    private static final SecretKey SECRET_KEY_SPEC = new SecretKeySpec(
            Base64.getEncoder().encode(SECRET_KEY.getBytes()),
            SignatureAlgorithm.HS256.getJcaName()
    );
//    private static final SecretKey SECRET_KEY_SPEC = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    private static final long ACCESS_TOKEN_VALIDITY = 1000 * 60 * 60 * 24;
    private static final long REFRESH_TOKEN_VALIDITY = 1000 * 60 * 60 * 24 * 7;
//
//    // JWT 생성
    public String createJWT(String email, MemberRole role){
        return Jwts.builder()
                .claim("email",email)
                .claim("role",role)
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
                .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY)) // 1초*60*60*24 1일 유효함
                .signWith(SECRET_KEY_SPEC)
                .compact();
    }

    public String createRefreshToken(){
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_VALIDITY))
                .signWith(SECRET_KEY_SPEC)
                .compact();
    }

    public Claims decodeJwt(String jwt){
        Jws<Claims> claims = Jwts.parser()
                .verifyWith(SECRET_KEY_SPEC)
                .build()
                .parseSignedClaims(jwt);

        return claims.getPayload();
    }

    public String getEmailFromJwt(String jwt){
        Claims claims = decodeJwt(jwt);
        return claims != null ? claims.get("email").toString() : "";
    }

    public String getRoleFromJwt(String jwt){
        Claims claims = decodeJwt(jwt);
        return claims.get("role").toString();
    }

    public boolean isValidToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(SECRET_KEY_SPEC)
                    .build()
                    .parseClaimsJws(token);
            return true; // 유효한 경우
        } catch (Exception e) {
            log.warn("Invalid token: {}", e.getMessage());
            return false; // 유효하지 않은 경우
        }
    }

    public boolean isValidAccessToken(String token){
        return isValidToken(token);
    }

    public boolean isValidRefreshToken(String token){
        return isValidToken(token);
    }

}
