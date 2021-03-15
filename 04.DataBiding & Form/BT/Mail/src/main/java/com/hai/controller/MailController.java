package com.hai.controller;


import com.hai.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("mail", new Mail());
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("mail") Mail mail, Model model){
        System.out.println(mail.toString());
        model.addAttribute("mail", mail);
        model.addAttribute("mess","Done...!!");
        return "index";
    }

}
