package com.example.portfolio001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/customer/signin")
    public String signinPage(){
        return "user/signinPage";
    }

    @GetMapping("/customer/createAccount")
    public String createAccount(){
        return "user/createAccount";
    }
}
