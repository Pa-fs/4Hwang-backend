package com.green.sahwang.controller;

import com.green.sahwang.entity.Member;
import com.green.sahwang.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("member")
@Slf4j
@RequiredArgsConstructor
public class MemberInfoController {

    private final MemberRepository memberRepository;


    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "로그인 사용자 정보 조회", description = "로그인 후 마이페이지 데이터")
    @GetMapping("info")
    public ResponseEntity<Member> getMemberInfo(@AuthenticationPrincipal UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok(member);
    }

}
