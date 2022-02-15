package com.zimug.boot.lanuch.controller;


import com.zimug.boot.lanuch.model.LombokPOJO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) throws FileNotFoundException {
        LombokPOJO lombokPOJO = new LombokPOJO(name,0);
        return "hello world---109" + name ;
    }
}
