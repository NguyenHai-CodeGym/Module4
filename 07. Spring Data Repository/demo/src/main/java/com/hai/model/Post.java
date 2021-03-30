package com.hai.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany
    @JoinTable(
            name = "tag_post",
            joinColumns = @JoinColumn (name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tagPost;

    public Post(){}

    public Post(Long id, String title, List<Tag> tagPost) {
        this.id = id;
        this.title = title;
        this.tagPost = tagPost;
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

    public List<Tag> getTagPost() {
        return tagPost;
    }

    public void setTagPost(List<Tag> tagPost) {
        this.tagPost = tagPost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tagPost=" + tagPost +
                '}';
    }
}
