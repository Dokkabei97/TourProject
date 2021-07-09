package com.t4er.web;

import com.t4er.config.login.Login;
import com.t4er.domain.member.Member;
import com.t4er.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class OlanController {

    @GetMapping("/")
    public String index(@Login Member loginMember, Model model) {

        if (loginMember == null) {
            return "index";
        }

        model.addAttribute("loginMember", loginMember);
        return "index";
    }
}
