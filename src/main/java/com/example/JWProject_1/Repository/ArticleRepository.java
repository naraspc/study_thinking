package com.example.JWProject_1.Repository;

import com.example.JWProject_1.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}