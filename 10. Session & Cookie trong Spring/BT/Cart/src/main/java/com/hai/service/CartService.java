package com.hai.service;

import com.hai.model.Cart;
import com.hai.model.Product;

import java.util.List;

public interface CartService<T> {

    List<T> showAll();

    void add(Product product, Cart cart);

    void edit(T t);

    T findById(int id);

    void delete(int id);
}
