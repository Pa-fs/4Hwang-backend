package com.green.sahwang.security.service;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.entity.enumtype.SnsType;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.security.dto.KakaoTokenDto;
import com.green.sahwang.security.dto.KakaoUserInfoDto;
import com.green.sahwang.security.dto.LoginReqDto;
import com.green.sahwang.security.entity.JWTRefreshToken;
import com.green.sahwang.security.entity.KakaoAccessToken;
import com.green.sahwang.security.entity.KakaoRefreshToken;
import com.green.sahwang.security.filter.JWTUtils;
import com.green.sahwang.security.repository.JWTRefreshTokenRepository;
import com.green.sahwang.security.repository.KakaoAccessTokenRepository;
import com.green.sahwang.security.repository.KakaoRefreshTokenRepository;
import com.green.sahwang.security.util.KakaoUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoServiceImpl implements KakaoService{

//    private final KakaoRepository kakaoRepository;
    private final MemberRepository memberRepository;
    private final Environment environment;
    private final JWTUtils jwtUtils;
    private final KakaoAccessTokenRepository kakaoAccessTokenRepository;
    private final KakaoRefreshTokenRepository kakaoRefreshTokenRepository;
    private final JWTRefreshTokenRepository jwtRefreshTokenRepository;
    private final PasswordEncoder passwordEncoder;

    /*
     1. 카카오 https://kauth.kakao.com/oauth/token -> accessToken 발급
     2. 카카오 https://kapi.kakao.com/v2/user/me -> 유저정보 가져오기
     3. KakaoEntity -> 테이블 행삽입 -> 해당하는 이메일 검사...
     4. JWT(JSON Web Token) -> JWTUtils.createJWT(email) 해서 반환...
     */

    @Transactional
    public String getToken(String code){
        try {
            String url = "https://kauth.kakao.com/oauth/token";
            RestTemplate restTemplate = new RestTemplate();

            MultiValueMap headers = new LinkedMultiValueMap();
            headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "authorization_code");
            body.add("client_id", environment.getProperty("oauth.kakao.client_id"));
            body.add("redirect_uri", "http://localhost:5173/login");
            body.add("code", code);
            body.add("client_secret", environment.getProperty("oauth.kakao.client_secret"));

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<KakaoTokenDto> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, KakaoTokenDto.class);
            log.info("result {}", result);
            KakaoTokenDto kakaoTokenDto = result.getBody();

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer "+ kakaoTokenDto.getAccessToken());
            ResponseEntity<KakaoUserInfoDto> res = restTemplate.exchange("https://kapi.kakao.com/v2/user/me",
                    HttpMethod.GET,
                    new HttpEntity<>(null, httpHeaders),
                    KakaoUserInfoDto.class);
            KakaoUserInfoDto kakaoUserInfoDto = res.getBody();

            String email = kakaoUserInfoDto.getKakaoAccount().getEmail();

            Member existingMember = memberRepository.findByEmail(email);

            if(existingMember != null){
                if (existingMember.getEmail().equals("thdghckd111@naver.com") || existingMember.getEmail().equals("kdh7313@naver.com") || existingMember.getEmail().equals("whgpals4263@nate.com")){
                    existingMember.setRole(MemberRole.ADMIN);
                }

                existingMember.setLastLoginDate(LocalDateTime.now());
                memberRepository.save(existingMember);

                KakaoAccessToken accessToken = kakaoAccessTokenRepository.findByMemberId(existingMember.getId());
                if (accessToken != null) kakaoAccessTokenRepository.delete(accessToken);

                KakaoRefreshToken refreshToken = kakaoRefreshTokenRepository.findByMemberId(existingMember.getId());
                if (refreshToken != null) kakaoRefreshTokenRepository.delete(refreshToken);

                JWTRefreshToken rfToken = jwtRefreshTokenRepository.findByMemberId(existingMember.getId());
                if (rfToken != null) jwtRefreshTokenRepository.delete(rfToken);

                KakaoAccessToken kakaoAccessToken = new KakaoAccessToken(kakaoTokenDto.getAccessToken(), existingMember.getId(), kakaoTokenDto.getExpiresIn());
                kakaoAccessTokenRepository.save(kakaoAccessToken);
                KakaoRefreshToken kakaoRefreshToken = new KakaoRefreshToken(kakaoTokenDto.getRefreshToken(), existingMember.getId(), kakaoTokenDto.getRefreshTokenExpiresIn());
                kakaoRefreshTokenRepository.save(kakaoRefreshToken);

                String jwtRefreshToken = jwtUtils.createRefreshToken();
                long ttl = calcTtlFromJwt(jwtRefreshToken);
                JWTRefreshToken JwtRefreshToken = new JWTRefreshToken(jwtRefreshToken, existingMember.getId(), ttl);
                jwtRefreshTokenRepository.save(JwtRefreshToken);

                return jwtUtils.createJWT(email, existingMember.getRole());
            } else {

                Member member = new Member();
                member.setEmail(kakaoUserInfoDto.getKakaoAccount().getEmail());
                member.setNickName(kakaoUserInfoDto.getKakaoAccount().getProfile().getNickname());
                member.setProfileImage(kakaoUserInfoDto.getProperties().getProfileImage());
                member.setThumbnailImage(kakaoUserInfoDto.getProperties().getThumbnailImage());
                member.setSnsType(SnsType.KAKAO);
                member.setJoinDate(LocalDateTime.now());
                member.setLastLoginDate(LocalDateTime.now());
                member.setRole(MemberRole.USER);

                memberRepository.save(member);

                KakaoAccessToken kakaoAccessToken = new KakaoAccessToken(kakaoTokenDto.getAccessToken(), member.getId(), kakaoTokenDto.getExpiresIn());
                kakaoAccessTokenRepository.save(kakaoAccessToken);
                KakaoRefreshToken kakaoRefreshToken = new KakaoRefreshToken(kakaoTokenDto.getRefreshToken(), member.getId(), kakaoTokenDto.getRefreshTokenExpiresIn());
                kakaoRefreshTokenRepository.save(kakaoRefreshToken);

                String jwtRefreshToken = jwtUtils.createRefreshToken();
                long ttl = calcTtlFromJwt(jwtRefreshToken);
                JWTRefreshToken JwtRefreshToken = new JWTRefreshToken(jwtRefreshToken, member.getId(), ttl);
                jwtRefreshTokenRepository.save(JwtRefreshToken);

                return jwtUtils.createJWT(email, member.getRole());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "fail";
    }

    @Transactional
    public String formLogin(LoginReqDto loginReqDto){
        Member member = memberRepository.findByEmail(loginReqDto.getEmail());
        if (member == null){
            throw new RuntimeException("사용자를 찾을 수 없습니다");
        }

        if (!passwordEncoder.matches(loginReqDto.getPassword(), member.getPassword())){
            throw new RuntimeException("비밀번호가 일치 하지 않습니다");
        }

        if(member.getRole() != MemberRole.ADMIN){
            throw new RuntimeException("관리자가 아닙니다");
        }

        member.setLastLoginDate(LocalDateTime.now());
        memberRepository.save(member);

        String jwtRefreshToken = jwtUtils.createRefreshToken();
        long ttl = calcTtlFromJwt(jwtRefreshToken);
        JWTRefreshToken JwtRefreshToken = new JWTRefreshToken(jwtRefreshToken, member.getId(), ttl);
        jwtRefreshTokenRepository.save(JwtRefreshToken);

        return jwtUtils.createJWT(member.getEmail(), member.getRole());

    }

    // 메시지 보내기 함수..
    // 1. jwt 내용 확인...(email 있는지..., 유효한토큰..) Email 가져오기..
    // 2. https://kapi.kakao.com/v2/api/talk/memo/default/send
    // headers = contectType accessToken
    // body template_object {   }
    // 우리가 발급한 JWT login..., AccessToken(유효시간)-> message X , RefreshToken(유효시간)

    @Override
    public void messageSend(String jwt, String message){
        String email = jwtUtils.getEmailFromJwt(jwt);
        log.info("email {}", email);
        Member member = memberRepository.findByEmail(jwtUtils.getEmailFromJwt(jwt));
        KakaoAccessToken kakaoAccessToken = kakaoAccessTokenRepository.findByMemberId(member.getId());
        String accessToken = kakaoAccessToken.getKakaoAccessToken();
        log.info("accessToken {}", accessToken);

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";

        MultiValueMap headers = new LinkedMultiValueMap();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
        headers.add("Authorization", "Bearer " + accessToken);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("template_object",String.format(KakaoUtils.messageString(), email, message));

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        log.info("msg 카카오 메시지 전송 성공");
    }

    public long calcTtlFromJwt(String jwt){

        Claims claims = jwtUtils.decodeJwt(jwt);
        Date expiration = claims.getExpiration();
        Date issuedAt = claims.getIssuedAt();

        long issuedAtTime = issuedAt.getTime();
        long expirationTime = expiration.getTime();

        return (expirationTime - issuedAtTime) / 1000;
    }
}
