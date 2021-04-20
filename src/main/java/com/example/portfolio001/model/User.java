package com.example.portfolio001.model;
/*

 */
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM -> Java (다른언어) Object -> 테이블로 맵핑해주는 기술

//테이블로 만들기 위해 @Entity 어노테이션을 쓰자!!
@Entity
public class User {

    @Id // @Id : primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 넘버링 전략 -> 해당 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; //sequence, auto_increment

    @Column(nullable = false, length = 100)
    private String email; //아이디로 이메일을 써야징 !!

    @Column(nullable = false, length = 100) //해쉬화 하면 길이가 길어진다!! 그러므로 좀 넉넉히
    private String password;

    @Column(nullable = false, length = 30) //유저이름
    private String username;

    @Column(nullable = false, length = 30) // 중복가입 차단, 본인인증, sms 광고 메시지
    private String telephone;

    @Column(nullable = false, length = 30) // 생일 이벤트, 연령제한상품, 인증
    private String dob;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = false, length = 30) // 계정 활성, 비활성 (휴면)
    private String is_active;

    @Column(nullable = false, length = 30) // 소셜로그인 가입자인지
    private String is_social;

    @Column(nullable = false, length = 30) //구독자 혜택 부여
    private String is_subscribed;

    @Column(nullable = false, length = 30) // 구매 총액 합계
    private int paymentPoint;

    @Column(nullable = false, length = 30)  // 구매 총액 * 0.01 = 포인트 현금처럼 결제가능
    private int mileage;

    @Column(nullable = false, length = 30) //마지막 로그인 날짜 , 휴면 활성 시킬수 있도록
    private Timestamp last_login;

    @ColumnDefault("'Bronze'") //문자임을 알려주기위해 쌍따옴표 안에 홑따옴표 넣어주세요
    @Column(nullable = false, length = 30) // 유저 등급 ( 50000 단위로 계급 증가, 시작은 bronze -> silver -> gold -> platinum -> diamond)
    private String rank;

    @CreationTimestamp //시간이 자동으로 입력됩니다. 가입날짜.
    private Timestamp createDate;
}
