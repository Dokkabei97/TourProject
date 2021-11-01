package com.t4er.member.ui;

import com.t4er.member.application.MemberService;
import com.t4er.member.dto.request.MemberRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerMember(MemberRegisterRequest memberDto) {
        memberService.registerMember(memberDto);

        return ResponseEntity.ok().build();
    }
}
