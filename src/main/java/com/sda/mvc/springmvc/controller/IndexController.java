package com.sda.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String test(){
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
