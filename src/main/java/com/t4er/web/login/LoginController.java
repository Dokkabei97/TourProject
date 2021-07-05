package com.t4er.web.login;

import com.t4er.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm() {

        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login() {

        return "redirect:/";
    }
}
