package com.green.sahwang.controller;

import com.green.sahwang.entity.Member;
import com.green.sahwang.repository.MemberRepository;
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

    @GetMapping("info")
    public ResponseEntity<Member> getMemberInfo(@AuthenticationPrincipal UserDetails userDetails){
        Member member = memberRepository.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok(member);
    }

}
