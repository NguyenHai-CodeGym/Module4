package com.hai.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "categoryID")
    private List<Post> post;

    public Category(){}

    public Category(Long id, String description, List<Post> postList) {
        this.id = id;
        this.description = description;
        this.post = postList;
    }

    public Category(Long id, String name, String description, List<Post> post) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Post> getPostList() {
        return post;
    }

    public void setPostList(List<Post> postList) {
        this.post = postList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", postList=" + post +
                '}';
    }
}
