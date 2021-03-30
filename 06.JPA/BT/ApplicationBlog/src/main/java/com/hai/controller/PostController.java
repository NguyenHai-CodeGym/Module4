package com.hai.controller;


import com.hai.model.Post;
import com.hai.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("list", postService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("post",new Post());
        return "add-post";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("post", postService.findById(id));
        return "edit-post";
    }

    @PostMapping("/doAdd")
    public String doAdd(Post post, RedirectAttributes attributes){
        postService.saveOrUpdate(post);
        attributes.addFlashAttribute("mess","DONE...!!!");
        return "redirect:/index";
    }

    @PostMapping("/doEdit")
    public String doEdit(Post post, RedirectAttributes attributes){
        postService.saveOrUpdate(post);
        attributes.addFlashAttribute("mess","DONE...!!!");
        return "redirect:/index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        postService.remove(id);
        attributes.addFlashAttribute("mess","Done...!!!");
        return "redirect:/index";
    }
}
