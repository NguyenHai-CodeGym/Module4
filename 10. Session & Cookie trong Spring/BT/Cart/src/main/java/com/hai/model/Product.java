package com.hai.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Product {
    @NotEmpty
    private int id;
    @NotEmpty
    @Size(min = 4,max = 250)
    private String name;
    @NotEmpty
    private String description;
    private String image;
    @NotEmpty
    @Min(1)
    private double price;

    public Product(){}

    public Product(@NotEmpty int id, @NotEmpty @Size(min = 4, max = 250) String name, @NotEmpty String description, String image, @NotEmpty @Min(1) double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}
