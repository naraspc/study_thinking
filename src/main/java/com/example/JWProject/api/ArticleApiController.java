package com.example.JWProject.api;

import com.example.JWProject.DTO.ArticleForm;
import com.example.JWProject.Repository.ArticleRepository;
import com.example.JWProject.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@ResponseStatus
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

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {

       // 수정용 엔티티 생성
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 대상 엔티티 조회
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청 처리(대상이 없거나 id가 다른경우)
        if (target == null | article.getId() != id ){
            log.info("잘못된 요청 ! id: {}, article: {}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Article updated = articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    //DELETE

}
