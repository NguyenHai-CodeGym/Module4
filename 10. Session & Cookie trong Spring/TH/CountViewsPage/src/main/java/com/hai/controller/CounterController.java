//package com.hai.controller;
//
//
//import com.hai.model.MyCounter;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//@Controller
//@SessionAttributes("mycounter")
//public class CounterController {
//
//    @ModelAttribute("mycounter")
//    public MyCounter setUpCounter(){
//        return new MyCounter();
//    }
//
//    @GetMapping("/index")
//    public String index(@ModelAttribute("mycounter") MyCounter myCounter, Model model){
//        myCounter.increment();
//        return "index";
//    }
//}
