package com.example.JWProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // 엔티티선언 DB가 인식 할수있게
@AllArgsConstructor // 생성자 자동 추가 어노테이션
@NoArgsConstructor // 디폴트 생성자 추가 어노테이션
@ToString // 롬복을 이용한 투스트링 자동 추가 어노테이션
@Getter // 필드값을 가공 후 외부로 전달
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 ID를 자동 생성하는 어노테이션
    private Long id; // PK 값

    @Column
    private String title; // DB TITLE

    @Column
    private String content; // DB CONTENT



}