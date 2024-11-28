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
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    @Override
    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain filterChain) throws ServletException, IOException {

        log.info("Security Filter");

        String authorization = request.getHeader("Authorization");
        log.info("Security Filter " + authorization);

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authorization.split("Bearer ")[1];
        String email = jwtUtils.getEmailFromJwt(jwt);
        String role = jwtUtils.getRoleFromJwt(jwt);


//        if(request.getRequestURI().contains("wish")){
//            System.out.println("wish 호출할때 role 확인 "+ role);
//            role="USER";
//            if(!role.equals("ADMIN")){
//
//            }
//        }

        if (email == null) {
            throw new UserException("사용자의 이메일을 찾을 수 없습니다");
        }
        // ROLE 을 추가해야 403 에러가 안뜬다
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        if(role.equals("USER"))
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        else if(role.equals("ADMIN"))
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else if(role.equals("SELLER"))
            roles.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        else if(role.equals("APPRAISER"))
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
        System.out.println("이거 나오냐" + authentication.getPrincipal());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        userDetails.getAuthorities().stream().forEach(grantedAuthority -> System.out.println(grantedAuthority));
//        log.info("Username : {}, Role : {}", authentication.getName(), );

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        log.info("인증 : {}", ((UserDetails) authentication.getPrincipal()).getUsername());

        filterChain.doFilter(request, response);
    }

}
