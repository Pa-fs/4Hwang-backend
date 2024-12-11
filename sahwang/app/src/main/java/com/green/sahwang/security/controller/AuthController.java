package com.green.sahwang.security.controller;

import com.green.sahwang.security.filter.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JWTUtils jwtUtils;

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshJwt(@RequestHeader("Authorization") String refreshToken){

        return null;
    }

}
