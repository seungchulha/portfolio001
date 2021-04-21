package com.example.portfolio001.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class KakaoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;

    @Column(nullable = false, length = 50)
    private String kakaoToken; //토큰 유효성 테스트 후 로그인 처리

    @CreationTimestamp
    private Timestamp createDate;
}
