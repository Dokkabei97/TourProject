package com.t4er.web.member;

import com.t4er.domain.member.Member;
import com.t4er.domain.member.MemberRepository;
import com.t4er.domain.member.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("member", new Member(Role.USER));
        return "member/join";
    }

    @PostMapping("/join")
    public String joined(Member member) {
        memberRepository.save(member);
        return "redirect:/";
    }
}
