package com.green.sahwang.security.filter;

import com.green.sahwang.security.error.UserException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    @Override
    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain filterChain) throws ServletException, IOException{

        log.info("Security Filter");

        String authorization = request.getHeader("Authorization");
        log.info("Security Filter"+authorization);

        if( authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authorization.split("Bearer ")[1];
        String email = jwtUtils.getEmailFromJwt(jwt);

        if(email == null){
            throw new UserException("사용자의 이메일을 찾을 수 없습니다");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                // userDetails 지정
                User.builder()
                        .username(email)
                        .password("temp")
                        .roles("USER")
                        .build(),null
        );

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

}
