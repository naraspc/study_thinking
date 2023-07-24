package com.example.JWProject_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FirstController  {
    @GetMapping("/hi")
    public String hello(Model model) {
        model.addAttribute("username", "nara");
        return "greetings"; // templates/greetings.mustache -> 해당 경로를 탐색해서 실행해준다.
    }

    @GetMapping("/bye")
        public String bye(Model model) {
        model.addAttribute("username", "nara");
        return "byebye";
        }

}
