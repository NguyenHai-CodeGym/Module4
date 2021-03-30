package com.hai.controller;


import com.hai.model.Customer;
import com.hai.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("list", customerService.findAll());
        return "index";
    }


    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("customer",new Customer());
        return "create-customer";
    }

    @PostMapping("/doAdd")
    public String doAdd(Customer customer, RedirectAttributes redirectAttributes){
        customerService.saveOrUpdate(customer);
        redirectAttributes.addFlashAttribute("mess","Thêm Mới Thàng Công...!!!");
        return "redirect:/index";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "update-customer";
    }

    @PostMapping("/doEdit")
    public String doEdit(Customer customer, RedirectAttributes attributes){
        customerService.saveOrUpdate(customer);
        attributes.addFlashAttribute("mess","Sửa Thành Công...!!!");
        return "redirect:/index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
       customerService.remove(id);
        attributes.addFlashAttribute("mess","Xóa Thành Công...!!!");
        return "redirect:/index";
    }
}
