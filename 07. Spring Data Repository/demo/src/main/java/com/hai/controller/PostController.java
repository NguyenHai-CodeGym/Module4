package com.hai.controller;


import com.hai.model.Post;
import com.hai.model.Tag;
import com.hai.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/add")
    @ResponseBody
    public String add(){
        return "";
    }
}
