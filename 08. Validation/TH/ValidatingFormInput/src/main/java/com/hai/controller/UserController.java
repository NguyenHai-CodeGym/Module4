package com.hai.controller;


import com.hai.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {


    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(@Validated @ModelAttribute("user") User user, BindingResult result){
        new User().validate(user,result);
        if (result.hasFieldErrors()){
            return "index";
        }
        return "result";
    }

}
