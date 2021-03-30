package com.hai.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Field implements Serializable {
    private static final long serialVersionUID = 1L;
    private Post post;
    private MultipartFile multipartFile;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Field(){}

    public Field(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    @Override
    public String toString() {
        return "Field{" +
                "multipartFile=" + multipartFile +
                '}';
    }
}
