package com.example.JWProject.DTO;

import com.example.JWProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 생성자 자동생성
@ToString // 투스트링 자동생성
public class ArticleForm {

    private Long id; // 변수명은 항상 위에
    private String title;
    private String content;

    public Article toEntity() { // DTO를 ENTITY로 변환
        return new Article(id, title, content); // ENTITY
    }


}
