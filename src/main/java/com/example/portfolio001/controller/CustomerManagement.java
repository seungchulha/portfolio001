package com.example.portfolio001.controller;

import com.example.portfolio001.model.RankType;
import com.example.portfolio001.model.User;
import com.example.portfolio001.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerManagement {

    @Autowired //의존성 주입 (DI)
    private UserRepository userRepository; //401 에러 원인은 이놈이였다

    @GetMapping("/customer/signin")
    public String signinPage(){
        return "user/signinPage";
    }

    @GetMapping("/customer/createAccount")
    public String createAccount(){
        return "user/createAccount";
    }

    @PostMapping("/customer/join")
    public String join(User user){
        user.setRank(RankType.Bronze); //Enum 타입의 정보는 여기서 세팅해주자
        userRepository.save(user);
        return "welcomePage/WelcomeNewCustomer";
    }

    @GetMapping("/customer/new/welcome")
    public String welcomeNew(){
        return "welcomePage/WelcomeNewCustomer";
    }
}

