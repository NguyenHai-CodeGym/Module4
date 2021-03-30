package com.hai.controller;


import com.hai.Service.CustomerService;
import com.hai.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("index")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("list", customerList);
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "create-customer";
    }


    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes) {
        customerService.save(customer);
        attributes.addFlashAttribute("mess", "Done...!!!");
        return "redirect:/index";
    }


    @GetMapping("/delete/{id}")
    public String detele(@PathVariable int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("mess","Done...!!!");
        return "redirect:/index";
    }


    @GetMapping("/edit/{id}")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "update-customer";
    }

    @PostMapping("doEdit")
    public String doEdit(Customer customer, RedirectAttributes attributes){
        attributes.addFlashAttribute("mess","Edit Done...!!!");
        customerService.update(customer);
        return "redirect:/index";
    }
}
