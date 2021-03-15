package com.hai.controller;



import com.hai.model.Product;
import com.hai.service.CategoryService;
import com.hai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("productList",productService.showAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("mess","Xoa thang cong");
        return "redirect:/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        CategoryService categoryService = new CategoryService();
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList",categoryService.showAll());
        return "add";
    }

    @PostMapping("/doAdd")
    public String doAdd(Product product, RedirectAttributes redirectAttributes){
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/index";
    }
}
