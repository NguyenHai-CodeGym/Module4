package com.hai.controller;


import com.hai.model.Customer;
import com.hai.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class CustomerController {
    CustomerService customerService = new CustomerService();
    @GetMapping("/customerList")
    public String showList(Model model){
        List<Customer> customerList = customerService.showAll();
        model.addAttribute("list",customerList);
        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model){
         customerService.delete(id);
        List<Customer> customerList = customerService.showAll();
        model.addAttribute("list",customerList);
        model.addAttribute("mess","Xoa thanh cong..!");
        return "index";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit-customer";
    }

    @GetMapping("/add")
    public String add(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "add-customer";
    }

    @PostMapping("/add")
    public String doAdd(@ModelAttribute("customer") Customer customer,Model model){
        customerService.addCustomer(customer);
        model.addAttribute("mess","Add thanh cong...!");
        model.addAttribute("list",customerService.showAll());
        return "index";
    }

    @PostMapping("/edit")
    public String doEdit(@ModelAttribute("customer") Customer customer, Model model){
        customerService.editCustomer(customer);
        List<Customer> customerList = customerService.showAll();
        model.addAttribute("mess","Edit thanh cong...!");
        model.addAttribute("list",customerList);
        return "index";
    }
}
