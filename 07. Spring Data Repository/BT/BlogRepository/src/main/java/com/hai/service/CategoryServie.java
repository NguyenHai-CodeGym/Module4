package com.hai.service;

import com.hai.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryServie{

    Page<Category> findAll(Pageable pageable);

    Page<Category> findAllByNameContaining(String name, Pageable pageable);


    Optional<Category> findById(Long id);


    void save(Category category);

    void remove(Long id);



}
