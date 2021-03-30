package com.hai.service;

import java.util.List;

public interface PostService<T> {
    List<T> findAll();

    T findById(Long id);

    void saveOrUpdate(T t);

    void remove(Long id);
}
