package com.example.JWProject_1.DTO;

import com.example.JWProject_1.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 생성자 자동생성
@ToString // 투스트링 자동생성
public class ArticleForm {

    public Article toEntity() { // DTO를 ENTITY로 변환
        return new Article(id, title, content); // ENTITY
    }
    private Long id;
    private String title;
    private String content;

}
