package com.hai.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class MyField implements Serializable {
    private static final long serialVersionUID = 1L;
    private MultipartFile multipartFile;
    private String description;

    public MyField(){}

    public MyField(MultipartFile multipartFile, String description) {
        this.multipartFile = multipartFile;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MyField{" +
                "multipartFile=" + multipartFile +
                ", description='" + description + '\'' +
                '}';
    }
}
