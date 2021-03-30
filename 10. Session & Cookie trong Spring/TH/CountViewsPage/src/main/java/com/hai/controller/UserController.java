package com.hai.controller;


import com.hai.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        User user = new User();
        if(cookies != null) {
            user.setUsername(cookies[0].getValue());
            model.addAttribute("user", user);
        }else {
            model.addAttribute("user", user);
           return "index";
        }
        return "index";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpServletResponse response){
        if ((user.getUsername()).equals("admin") || (user.getUsername().equals("admin2")) && (user.getPassword().equals("admin"))){
            Cookie cookie = new Cookie("userName", user.getUsername());
            

            response.addCookie(cookie);
            return "result";
        }
        return "index";
    }
}
