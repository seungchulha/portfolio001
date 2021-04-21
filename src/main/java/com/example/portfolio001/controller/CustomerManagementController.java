package com.example.portfolio001.controller;

import com.example.portfolio001.model.RankType;
import com.example.portfolio001.model.User;
import com.example.portfolio001.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.ClientAuth;
import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class CustomerManagementController {

    @Autowired //의존성 주입 (DI)
    private UserRepository userRepository; //401 에러 원인은 이놈이였다

    /*
    update will be on
    telephone, password, is_active, is_social, is_subscribed, payment, mileage, last_login, rank
     */

    @DeleteMapping("/customer/user/{id}")
    public String delete(@PathVariable int id){
        try{
            userRepository.deleteById(id);
        } catch (Exception e){
            return "삭제에 실패하였습니다.";
        }

        return "성공적으로 삭제되었습니다.";
    }

    @Transactional
    @PutMapping("/customer/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){

        //json 데이터를 요청 => java object 로변환해서 받아준다 (Jackson )

        System.out.println("id: " + id);
        System.out.println("password: " + requestUser.getPassword());
        System.out.println("email: " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다.");
                });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
        // userRepository.save(user);
        return user;
    }

    // http://localhost:8000/moment4u/customer/user
    @GetMapping("/customer/user")
    public List<User> list(){
        return userRepository.findAll();
    }

    //한 페이지당 두건의 데이터를 리턴받아보자
    @GetMapping("/customer/user/page")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);
        List<User> users = pagingUser.getContent();
        return users;
    }

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

        //요청 : 웹 브라우저
        //user 객체 = 자바 오브젝트
        //변환 ( 웹 브라우저가 이해할 수 있는 데이터 ) -> json (GSON 라이브러리)
        //스프링 부트는 MessageConverter 라는 것이 응답시에 자동작동해서
        // 만약에 자바 오브젝트를 리턴하게되면 MessageConverter가 Jackson 라이브러리를 호출해서
        //user 오브젝트를 json으로 변환해서 브라우저에 던져줍니다.
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