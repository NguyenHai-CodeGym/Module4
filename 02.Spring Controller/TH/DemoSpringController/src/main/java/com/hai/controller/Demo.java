package com.hai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Demo {

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
