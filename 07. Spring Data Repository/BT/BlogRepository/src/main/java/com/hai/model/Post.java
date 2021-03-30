package com.hai.model;


import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "short_content")
    private String shortContent;
    @Column(name = "full_content")
    private String fullContent;
    @Column(name = "image")
    private String image;
    @Column(name = "publish")
    private String publish;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryID;

    public Post(){}

    public Post(Long id, String title, String shortContent, String fullContent, String image, String publish, Category categoryID) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.image = image;
        this.publish = publish;
        this.categoryID = categoryID;
    }

    public Post(Long id, String title, String shortContent, String fullContent, String image, Category categoryID) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.image = image;
        this.categoryID = categoryID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortContent='" + shortContent + '\'' +
                ", fullContent='" + fullContent + '\'' +
                ", publish='" + publish + '\'' +
                ", categoryID=" + categoryID +
                '}';
    }
}
