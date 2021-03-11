package com.hai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperatorController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/process")
    public String operator(@RequestParam float fisrtNum, float secondNum, String operator, Model model){
         switch (operator){
             case "+":
                 model.addAttribute("result", fisrtNum + secondNum);
                 break;
             case "-":
                 model.addAttribute("result", fisrtNum - secondNum);
                 break;
             case "*":
                 model.addAttribute("result",fisrtNum * secondNum);
                 break;
             case "/":
                 if (secondNum == 0){
                     model.addAttribute("result","Không thể chia 1 số cho 0");
                 }else {
                     model.addAttribute("result",fisrtNum / secondNum);
                 }
                 break;
         }

        return "index";
    }
}
