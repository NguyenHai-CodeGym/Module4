package com.hai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class Dictionary {

    static HashMap<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("January","Tháng 1");
        hashMap.put("February","Tháng 2");
        hashMap.put("March","Tháng 3");
        hashMap.put("April","Tháng 4");
        hashMap.put("July","Tháng 7");
        hashMap.put("August","Tháng 8");
        hashMap.put("September","Tháng 9");
        hashMap.put("October ","Tháng 10");
        hashMap.put("November ","Tháng 11");
        hashMap.put("November ","Tháng 12");
    }


    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/search")
    public String result(@RequestParam String month, Model model){
    if (hashMap.get(month) != null){
        model.addAttribute("result",hashMap.get(month));
    }else {
        model.addAttribute("result","Không tìm thấy kết quả");
    }
    return "index";
    }
}
