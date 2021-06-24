package com.t4er.member.controller;

import com.t4er.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @PostMapping("/join")
    public String joined() {
//        memberRepository.save();
        return "";
    }
}
