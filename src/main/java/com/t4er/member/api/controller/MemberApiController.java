package com.t4er.member.api.controller;

import com.t4er.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/api")
public class MemberApiController {

    private final MemberRepository memberRepository;
}
