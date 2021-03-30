package com.hai.service;

import com.hai.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllByNameContaining(String name, Pageable pageable);


    Post findById(Long id);


    void save(Post post) ;


    void remove(Long id) ;


}
