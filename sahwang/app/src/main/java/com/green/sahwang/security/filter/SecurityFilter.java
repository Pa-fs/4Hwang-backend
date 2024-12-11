package com.green.sahwang.security.filter;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.repository.PaymentRepository;
import com.green.sahwang.security.entity.JWTRefreshToken;
import com.green.sahwang.security.error.UserException;
import com.green.sahwang.security.repository.JWTRefreshTokenRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    private final MemberRepository memberRepository;

    private final JWTRefreshTokenRepository jwtRefreshTokenRepository;

    public SecurityFilter(JWTUtils jwtUtils, MemberRepository memberRepository, JWTRefreshTokenRepository jwtRefreshTokenRepository) {
        this.jwtUtils = jwtUtils;
        this.memberRepository = memberRepository;
        this.jwtRefreshTokenRepository = jwtRefreshTokenRepository;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain filterChain) throws ServletException, IOException {

        log.info("Security Filter");
        log.info("response : {}", response);

        String authorization = request.getHeader("Authorization");
        log.info("Security Filter " + authorization);

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authorization.split("Bearer ")[1];

        if (jwtUtils.isValidAccessToken(jwt)) {

            String email = jwtUtils.getEmailFromJwt(jwt);
            String role = jwtUtils.getRoleFromJwt(jwt);

            if (email == null) {
                throw new UserException("사용자의 이메일을 찾을 수 없습니다");
            }
            // ROLE 을 추가해야 403 에러가 안뜬다
            Set<SimpleGrantedAuthority> roles = new HashSet<>();
            if (role.equals("USER"))
                roles.add(new SimpleGrantedAuthority("ROLE_USER"));
            else if (role.equals("ADMIN"))
                roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            else if (role.equals("SELLER"))
                roles.add(new SimpleGrantedAuthority("ROLE_SELLER"));
            else if (role.equals("APPRAISER"))
                roles.add(new SimpleGrantedAuthority("ROLE_APPRAISER"));

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    // userDetails 지정
                    User.builder()
                            .username(email)
                            .password("")
                            .roles(role)
                            .build(), null, roles
            );

            log.info("Authentication: {}", authentication);
            log.info("role : {}", role);
//        System.out.println("이거 나오냐" + authentication.getPrincipal());
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        userDetails.getAuthorities().stream().forEach(grantedAuthority -> System.out.println(grantedAuthority));
//        log.info("Username : {}, Role : {}", authentication.getName(), );

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);

            log.info("인증 : {}", ((UserDetails) authentication.getPrincipal()).getUsername());

            filterChain.doFilter(request, response);
        }
        else {
            String email = jwtUtils.getEmailFromJwt(jwt);
            MemberRole role = MemberRole.valueOf(jwtUtils.getRoleFromJwt(jwt));
            Member member = memberRepository.findByEmail(email);
            JWTRefreshToken token = jwtRefreshTokenRepository.findByMemberId(member.getId());
            if (token.getJwtRefreshToken() != null && jwtUtils.isValidRefreshToken(token.getJwtRefreshToken())){
                String newJwt = jwtUtils.createJWT(email, role);
                response.setHeader("Access-Token", newJwt);
                filterChain.doFilter(request, response);
            }
            else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("JWT 토큰 및 REFRESH 토큰이 유효하지 않습니다");
            }
        }
    }

}
