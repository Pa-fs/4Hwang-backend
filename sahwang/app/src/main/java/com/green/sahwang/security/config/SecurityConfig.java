package com.green.sahwang.security.config;

import com.green.sahwang.repository.MemberRepository;
import com.green.sahwang.security.filter.JWTUtils;
import com.green.sahwang.security.filter.SecurityFilter;
import com.green.sahwang.security.repository.JWTRefreshTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // filter 지나감
@EnableMethodSecurity(prePostEnabled = true) // interceptor 지나감
public class SecurityConfig {

    private final MemberRepository memberRepository;

    private final JWTRefreshTokenRepository jwtRefreshTokenRepository;

    public SecurityConfig(MemberRepository memberRepository, JWTRefreshTokenRepository jwtRefreshTokenRepository) {
        this.memberRepository = memberRepository;
        this.jwtRefreshTokenRepository = jwtRefreshTokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/**").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/kakao/login").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/**").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/detail/**").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/type/**").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/kakao/msg").authenticated())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/wish/**").authenticated())
                .addFilterBefore(new SecurityFilter(new JWTUtils(), memberRepository, jwtRefreshTokenRepository), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();

    }

}
