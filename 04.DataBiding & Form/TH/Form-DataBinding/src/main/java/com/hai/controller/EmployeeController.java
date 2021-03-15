package com.hai.controller;


import com.hai.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("employee",new Employee());
        return "index";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model){
    if (result.hasErrors()){
        List<ObjectError> errorList = result.getAllErrors();
        for (ObjectError error : errorList){
            System.out.println(error.toString());
        }
        return "index";
    }
        model.addAttribute("employee", employee);
        return "info";
    }
}
