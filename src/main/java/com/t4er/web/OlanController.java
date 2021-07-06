package com.t4er.web;

import com.t4er.domain.member.Member;
import com.t4er.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class OlanController {

    @GetMapping("/")
    public String index(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        model.addAttribute("loginMember", loginMember);
        return "index";
    }
}
