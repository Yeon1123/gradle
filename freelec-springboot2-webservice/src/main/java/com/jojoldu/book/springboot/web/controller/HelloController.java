package com.jojoldu.book.springboot.web.controller;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return ("hello");
    }

    /**
     *  name, amount 값을 받아 json 형태로 리턴해주는 코드
     */ 
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, 
                                    @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
    
}
