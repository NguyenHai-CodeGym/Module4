package com.hai.service;

import com.hai.model.Post;
import com.hai.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements PostService<Post> {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Post post) {
    postRepository.saveOrUpdate(post);
    }

    @Override
    public void remove(Long id) {
    postRepository.remove(id);
    }
}
