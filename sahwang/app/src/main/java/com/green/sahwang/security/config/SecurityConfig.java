package com.green.sahwang.security.config;

import com.green.sahwang.security.filter.JWTUtils;
import com.green.sahwang.security.filter.SecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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
                .addFilterBefore(new SecurityFilter(new JWTUtils()), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();

    }

}
