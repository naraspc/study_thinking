package com.example.JWProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FirstController  {
    @GetMapping("/hi") // url hi 매핑
    public String hello(Model model) {
        model.addAttribute("username", "nara");
        return "greetings"; // templates/greetings.mustache -> 해당 경로를 탐색해서 실행해준다.
    }

    @GetMapping("/bye") // url bye 매핑
        public String bye(Model model) {
        model.addAttribute("username", "nara");
        return "byebye";
        }

}
