package com.example.JWProject_1.DTO;

import com.example.JWProject_1.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    public Article toEntity() {
        return new Article(null, title, content);
    }

    private String title;
        private String content;

}
