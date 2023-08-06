package com.example.JWProject.service;

import com.example.JWProject.Repository.ArticleRepository;
import com.example.JWProject.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //서비스 선언 어노테이션 (서비스 객체를 스프링 부트에 생성)
public class ArticleService {
    @Autowired // DI
    private static ArticleRepository articleRepository;


    public static List<Article> index() {
        return articleRepository.findAll();
    }
}
