package com.hai.controller;


import com.hai.model.Field;
import com.hai.model.Post;
import com.hai.service.CategoryServie;
import com.hai.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class BlogController {

    @Autowired
    private PostService postService;
    @Autowired
    private CategoryServie categoryServie;


    @GetMapping("/index")
    public String index(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("list", postService.findAll(pageable));
        return "index";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("field", new Field());
        return "create-post";
    }

    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("filed") Field field, RedirectAttributes attributes, HttpServletRequest request) throws IOException {
        String RealPath = request.getServletContext().getRealPath("fieldUpload");
        File uploadRootDir = new File(RealPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        MultipartFile multipartFile = field.getMultipartFile();
        String name = multipartFile.getOriginalFilename();
        if (name != null && name.length() > 0) {
            try {
                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(multipartFile.getBytes());
                stream.close();
                Post post = field.getPost();
                post.setImage(name);
                postService.save(post);
            } catch (Exception e) {
                return "redirect:/index";
            }
        }
        return "redirect:/index";
    }
}
