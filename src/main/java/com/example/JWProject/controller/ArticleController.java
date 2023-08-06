package com.example.JWProject.controller;

import com.example.JWProject.DTO.ArticleForm;
import com.example.JWProject.Repository.ArticleRepository;
import com.example.JWProject.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

    @Controller // 컨트롤러 선언
    @Slf4j //로깅을 위한 어노테이션
public class ArticleController {
    @Autowired //type으로 의존성 주입
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new") // url 매핑
    public String newArticleForm() {
        return "articles/new"; // new.mustache 리턴
    }

    @PostMapping("/articles/create") //데이터가 커질 수 있기때문에 Post 방식으로
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
        return "redirect:/articles/" + saved.getId(); // DTO를 DB에 저장 후 저장한값을 보여주는 페이지로 리다이렉트


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

    @GetMapping("/articles") //메인페이지
    public String index(Model model) {

        // 1: 모든 Article을 가져온다
        List<Article> articleEntityList = articleRepository.findAll();
        // 2: 가져온 Article 묶음을 뷰로 전달한다
        model.addAttribute("articleList", articleEntityList);
        // 3: 뷰 페이지를 설정한다
        return "articles/index"; // articles/index.mustache
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);
        // 뷰 페이지 설정
        return "articles/edit";

    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) { // 컨트롤러에서 받아온 데이터를 DTO로 변환
        log.info(form.toString()); // sysout 보단 log 사용하기.
        // System.out.println(form.toString());


        // DTO -> ENTITY 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
        // System.out.println(article);

        //id로 칼럼 조회후 수정
        Article article = articleRepository.findById(articleEntity.getId()).orElse(null); // articleEntity의 getid 메소드로 id를 호출해서 그 id로 값 찾기
        log.info(article.toString());
        // ENTITY -> DBMS 데이터처리
        if (article != null) {
            Article saved = articleRepository.save(articleEntity); // 값 수정
            log.info(saved.toString());
            // System.out.println(saved.toString());
            return "redirect:/articles/" + saved.getId(); // DTO를 DB에 저장 후 저장한값을 보여주는 페이지로 리다이렉트
        } else {
            return "데이터가 존재하지않습니다 수정불가";
        }
    }


    @GetMapping("/articles/delete") // url 매핑
    public String delete(long id) { // Primary Key값을 받아서
        log.info("삭제요청이 들어왔습니다");

        articleRepository.deleteById(id); //id 조회해서 동일하면 삭제
        return "redirect:/articles/";

    }

}


