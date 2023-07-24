package com.example.JWProject_1.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // 엔티티선언 DB가 인식 할수있게
@AllArgsConstructor // 생성자 자동 추가 어노테이션
@NoArgsConstructor // 디폴트 생성자 추가 어노테이션
@ToString // 롬복을 이용한 투스트링 자동 추가 어노테이션

public class Article {

    @Id
    @GeneratedValue
    private Long id; // PK 값

    @Column
    private String title; // DB TITLE

    @Column
    private String content; // DB CONTENT


}