package com.example.JWProject_1.controller;

import com.example.JWProject_1.DTO.ArticleForm;
import com.example.JWProject_1.Repository.ArticleRepository;
import com.example.JWProject_1.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        // System.out.println(form.toString());


        // DTO -> ENTITY
        Article article = form.toEntity();
        log.info(article.toString());
        // System.out.println(article);


        // ENTITY -> DBMS
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        // System.out.println(saved.toString());
        return "";


    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id) {
        log.info("id = " + id);

        // 1: ID로 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2: 가져온 데이터를 모델에 등록

        // 3: 보여줄 페이지를 설정

        return "";
    }


}
