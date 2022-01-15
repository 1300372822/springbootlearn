package com.example.springbootlearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//主程序以及子目录的包都能被扫描到
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01()
    {
        new HashMap<>(10);
        return "hello,spring boot 2!你好";
    }
}
