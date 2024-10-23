package com.green.sahwang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.cors(cors -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(
                        List.of("http://192.168.0.*:5173", "http://127.0.0.1:5173", "http://localhost:5173"));
                config.setAllowedMethods(
                        List.of("GET", "POST"));
                config.setAllowedHeaders(List.of("*"));
                return config;
            };
            cors.configurationSource(source);
        });

        http.csrf(
                csrf -> csrf.disable()
        );

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().permitAll()
        );

        return http.build();
    }
}
