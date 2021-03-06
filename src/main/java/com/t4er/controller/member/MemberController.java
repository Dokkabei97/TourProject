package com.t4er.controller.member;

import com.t4er.domain.member.Member;
import com.t4er.domain.member.Role;
import com.t4er.service.member.MemberService;
import com.t4er.dto.member.MemberJoinDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("member", new Member(Role.USER));
        return "member/join";
    }

    @PostMapping("/join")
    public String joined(@ModelAttribute("member")MemberJoinDto member) {
        memberService.join(member);
        return "redirect:/";
    }
}
