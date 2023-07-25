package com.example.JWProject_1.Repository;

import com.example.JWProject_1.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> { // CrudRepository 를 상속받아 오버라이드해서 사용

    @Override
    ArrayList<Article> findAll(); // findAll 메소드의 리턴타입을 어레이리스트로 오버라이드
}