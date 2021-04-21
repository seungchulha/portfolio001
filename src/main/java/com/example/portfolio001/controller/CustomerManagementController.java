package com.example.portfolio001.controller;

import com.example.portfolio001.model.RankType;
import com.example.portfolio001.model.User;
import com.example.portfolio001.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.ClientAuth;
import java.util.function.Supplier;

@RestController
public class CustomerManagementController {

    @Autowired //의존성 주입 (DI)
    private UserRepository userRepository; //401 에러 원인은 이놈이였다

    //람다식 표현
    // User user = userRepository.findById(id).orElseThrow(()->{
    //      return new IllegalArgumentException("해당 사용자는 없습니다.");
    // });

    //{id} 주소로 파라미터 전달 받을 수 있습니다
    //ex: http://localhost:8000/moment4u/customer/user/0
    @GetMapping("/customer/user/{id}")
    public User detail(@PathVariable int id){
        //user/4 를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null 이 될 것 아냐?
        //그러면 return null 이 되잖아.. 그럼 프로그램에 문제가 있지 않겠니?
        // 그래서 난 Optional 로 너의 User 객체를 감싸서 가져올테니 null 인지 아닌지 판단해서 return 해
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
            }
        });
        return user;
    }

    @PostMapping("/customer/join")
    public String join(User user){
        user.setRank(RankType.Bronze); //Enum 타입의 정보는 여기서 세팅해주자
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}


//id , email, password, telephone, dob, gender, is_active, is_social, is_subscribed, paymentPoint, mileage, last_login