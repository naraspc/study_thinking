package com.example.JWProject.api;

import com.example.JWProject.Repository.ArticleRepository;
import com.example.JWProject.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // RestAPI 컨트롤러 (JSON반환)
public class ArticleApiController {
    @Autowired // 외부에서 가져오기
    private ArticleRepository articleRepository;
    //GET
    @GetMapping("/api/articles") // 모든 객체 반환
    public List<Article> index() {
        return articleRepository.findAll();

    }
    @GetMapping("/api/articles/{id}") // 단일 객체 반환
    public Article index(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);

    }
    //POST

    //PATCH

    //DELETE

}
