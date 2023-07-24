package com.example.JWProject_1.Repository;

import com.example.JWProject_1.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> { // CrudRepository 를 상속받아 오버라이드해서 사용

}