package com.example.portfolio001.model;

import javax.persistence.*;

@Entity
public class KakaoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String kakaoToken; //토큰 유효성 테스트 후 로그인 처리

}
