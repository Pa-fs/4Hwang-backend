package com.green.sahwang.security.controller;

import com.green.sahwang.security.dto.LoginReqDto;
import com.green.sahwang.security.service.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kakao")
@Slf4j
@CrossOrigin
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("login")
    public ResponseEntity<String> kakaoCode(@RequestParam(value = "code") String code){
        String jwt = kakaoService.getToken(code);


        return ResponseEntity.ok(jwt);
    }

    @PostMapping("formLogin")
    public ResponseEntity<String> formLogin(@RequestBody LoginReqDto loginReqDto){
        String jwt = kakaoService.formLogin(loginReqDto);

        return ResponseEntity.ok(jwt);
    }

    @GetMapping("msg")
    public ResponseEntity<String> messageSend(@RequestParam(value = "message") String message,
                                              @RequestHeader(value = "Authorization", required = false) String authorization){
        log.info(authorization);
        try {
            String jwt = authorization.split("Bearer ")[1];
            log.info("jwt {}", jwt);
            kakaoService.messageSend(jwt, message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("jwt empty");
        }
        return ResponseEntity.ok("Message Send OK");
    }

}
