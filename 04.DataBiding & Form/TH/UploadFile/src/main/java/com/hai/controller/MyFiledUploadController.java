package com.hai.controller;


import com.hai.model.MyField;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
public class MyFiledUploadController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("MyFiled", new MyField());
        return "home";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@ModelAttribute("MyFiled") MyField myField, Model model){
        try {
            MultipartFile multipartFile = myField.getMultipartFile();
            String fileName = multipartFile.getOriginalFilename();
            File file = new File("D:\\Code Gym\\Module4\\04.DataBiding & Form\\TH\\UploadFile\\image",fileName);
            multipartFile.transferTo(file);
            model.addAttribute("message", "upload success");
            model.addAttribute("description", myField.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "upload failed");
        }
        return "file";
    }
}
