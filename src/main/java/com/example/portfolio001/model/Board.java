package com.example.portfolio001.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터 사용시 사용되는 @Lob 어노테이션
    private String content; // summernote 사용시 <html> 태그가 섞여서 디자인 된다.

    @ColumnDefault("0") // int 니까 홑따옴표 안쓴다.
    private int count;

    @ManyToOne // @ManyToOne -> Board는 many , user는 one 이라는 의미 --> 한명의 유저가 여러 게시글을 쓸수 있으나, 게시글의 유저는 한명이다 라는 의미
    @JoinColumn(name="userid") // @JoinColumn ->
    private User user; // 데이터베이스는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트를 저장할수 있다.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
