package com.hai.service;

import java.util.List;

public interface ProductService<T> {

    List<T> showAll();

    void add(T t);

    void edit(T t);

    T findById(int id);

    void delete(int id);
}
