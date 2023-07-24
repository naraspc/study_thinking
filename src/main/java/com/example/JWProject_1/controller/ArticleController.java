package com.example.JWProject_1.controller;
import com.example.JWProject_1.DTO.ArticleForm;
import com.example.JWProject_1.Repository.ArticleRepository;
import com.example.JWProject_1.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 컨트롤러 선언
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {
    @Autowired //type으로 의존성 주입
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new") // url 매핑
    public String newArticleForm() {
        return "articles/new"; // new.mustache 리턴
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) { // 컨트롤러에서 받아온 데이터를 DTO로 변환
        log.info(form.toString()); // sysout 보단 log 사용하기.
        // System.out.println(form.toString());


        // DTO -> ENTITY 변환
        Article article = form.toEntity();
        log.info(article.toString());
        // System.out.println(article);


        // ENTITY -> DBMS 데이터처리
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        // System.out.println(saved.toString());
        return "";


    }

    @GetMapping("/articles/{id}") //URL을 입력받아 (1~...) 매핑
    public String show(@PathVariable Long id, Model model) { // 입력받은 ID값 처리
        log.info("id = " + id);

        // 1: ID로 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2: 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);
        // 3: 보여줄 페이지를 설정
        return "articles/show";

    }


}
