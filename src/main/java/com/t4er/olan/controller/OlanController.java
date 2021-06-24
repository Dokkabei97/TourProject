package com.t4er.olan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OlanController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
