package com.hai.comtroller;


import com.hai.model.Cart;
import com.hai.model.Product;
import com.hai.service.CartService;
import com.hai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ProductController {
    @Autowired
    private ProductService<Product> productService;

    @Autowired
    private CartService<Cart> cartService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("list",productService.showAll());
        return "index";
    }


    @GetMapping("views/{id}")
    public String viewProduct(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "views";
    }


    @GetMapping("cart/{id}")
    public String addCart(HttpSession session, @PathVariable int id, Model model){
        Cart cart = (Cart) session.getAttribute("carts");
        if (cart == null) {
            cart = new Cart();
            Product product = productService.findById(id);
            cartService.add(product,cart);
            session.setAttribute("carts",cart);
        }else {
            Product product = productService.findById(id);
            cartService.add(product,cart);
        }
        return "cart";
    }
}
