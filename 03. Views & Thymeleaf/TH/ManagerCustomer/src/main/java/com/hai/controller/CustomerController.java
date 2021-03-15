package com.hai.controller;


import com.hai.model.Customer;
import com.hai.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    CustomerService customerService = new CustomerService();

//    Trang Index
    @GetMapping("/index")
    public String index(Model model) {
        List<Customer> customerList = customerService.showAll();
        model.addAttribute("customerList", customerList);
        return "index";
    }


//    Method Tao moi
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/index";
    }


//    Method Xoa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes, Model model) {
        Customer customer = customerService.remove(id);
        if (customer != null) {
            redirectAttributes.addFlashAttribute("mess", "xoa thanh cong");
        }else {
            redirectAttributes.addFlashAttribute("mess","Khong thang cong");
        }

        return "redirect:/index";
    }


//    Method Sua
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/doEdit")
    public String doEdit(Customer customer, Model model,RedirectAttributes redirectAttributes ){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Sửa thanh cong");
        return "redirect:/index";
    }

//    Views info
    @GetMapping("/view/{id}")
    public String views(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "views";
    }

}
