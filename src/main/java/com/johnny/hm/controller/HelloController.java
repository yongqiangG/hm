package com.johnny.hm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello,hm";
    }
    @GetMapping("/employee/basic")
    public String basic(){
        return "/employee/basic/**";
    }
    @GetMapping("/employee/advanced")
    public String advanced(){
        return "/employee/advanced/**";
    }
}
