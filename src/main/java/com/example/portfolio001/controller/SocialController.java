package com.example.portfolio001.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialController {

    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(){
        return "<h1>hello spring boot</h1>";
    }
}
