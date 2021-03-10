package com.hai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoney {

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @PostMapping("/convert")
    public String convert(@RequestParam int money, String convertFrom, String convertTo, Model model){
        if (convertFrom.equals(convertTo)){
            model.addAttribute("moneyConvert", money);
        }
        if (convertFrom.equals("VND") && convertTo.equals("USD")){
            model.addAttribute("moneyConvert",money / 23000);
        }
        if (convertFrom.equals("USD") && convertTo.equals("VND")){
            model.addAttribute("moneyConvert",money * 23000);
        }
        return "index";
    }
}
