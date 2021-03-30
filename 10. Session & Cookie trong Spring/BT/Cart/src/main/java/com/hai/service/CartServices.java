package com.hai.service;

import com.hai.model.Cart;
import com.hai.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServices implements CartService<Cart> {

    @Autowired
    private ProductService productService;

    @Override
    public List<Cart> showAll() {
        return null;
    }

    @Override
    public void add(Product product,Cart cart) {
        LinkedHashMap<Product, Integer> carts = cart.getCarts();
        if(!carts.containsKey(product)){
            carts.put(product,1);
        }else {
           int quanti = carts.get(product) ;
           carts.put(product,quanti+1);
        }
        double total = 0;
        for(Map.Entry<Product,Integer> entry : carts.entrySet()){
            total += entry.getKey().getPrice() * entry.getValue();
        }
        cart.setTotal(total);
    }

    @Override
    public void edit(Cart cart) {

    }

    @Override
    public Cart findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
