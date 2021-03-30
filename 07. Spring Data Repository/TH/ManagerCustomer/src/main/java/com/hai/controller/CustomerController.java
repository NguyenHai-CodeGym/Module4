package com.hai.controller;


import com.hai.model.Customer;
import com.hai.repository.CustomerRepository;
import com.hai.repository.ProvinceRepository;
import com.hai.service.CustomerService;
import com.hai.service.CustomerServiceImpl;
import com.hai.service.ProvinceService;
import com.hai.service.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {

   @Autowired
   CustomerService customerService;

   @Autowired
   ProvinceService provinceService;

    @GetMapping("/index")
    public String index(Model model,@PageableDefault(size = 5) Pageable page){
        model.addAttribute("list",customerService.findAll(page));
        return "index";
    }


    @PostMapping("/search")
    public String search(@RequestParam Optional<String> search, Model model, @PageableDefault(size = 5) Pageable pageable){
           model.addAttribute("list",customerService.findAllByNameContaining(search.get(),pageable));
        return "index";
    }

    @GetMapping("add")
    public String add(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("provinces",provinceService.findAll());
        return "create-customer";
    }

    @PostMapping("doAdd")
    public String doAdd(Customer customer, RedirectAttributes attributes){
        customerService.save(customer);
        attributes.addFlashAttribute("mess","Done...!!!");
        return "redirect:/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        customerService.remove(id);
        attributes.addFlashAttribute("mess","Done...!!!");
        return "redirect:/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        model.addAttribute("provinces", provinceService.findAll());
        return "edit-customer";
    }
}
