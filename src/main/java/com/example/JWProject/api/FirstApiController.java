package com.example.JWProject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestAPI용 컨트롤러 Json을 리턴함
public class FirstApiController {

    @GetMapping("/api/hello")
    public  String hello() {
        return "hello world!";
    }
}
