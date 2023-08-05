package com.example.JWProject.api;

import com.example.JWProject.DTO.ArticleForm;
import com.example.JWProject.Repository.ArticleRepository;
import com.example.JWProject.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/api/articles")
    public Article Create(@RequestBody ArticleForm dto) { // 전달받은 Json데이터를 DTO로 변환
        Article article = dto.toEntity(); // DTO를 엔티티로 변환하여 article로 저장
        return articleRepository.save(article); //aritcle을 db에 저장한다
    }

    //PATCH

    //DELETE

}
