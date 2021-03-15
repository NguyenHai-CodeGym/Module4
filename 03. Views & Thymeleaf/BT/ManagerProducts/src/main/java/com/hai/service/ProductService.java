package com.hai.service;

import com.hai.model.Category;
import com.hai.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IBaseService<Product> {
    CategoryService categoryService;
    List<Product> productList = new ArrayList<>();
    int id;
    @Autowired
    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;

        productList.add(new Product(++id, "IPhone", 100.0, 100, categoryService.findById(0)));
        productList.add(new Product(++id, "Asus", 50.0, 100, categoryService.findById(1)));
        productList.add(new Product(++id, "TiVI 4k", 800.0, 100, categoryService.findById(2)));
        productList.add(new Product(++id, "PC core i7", 400.0, 100, categoryService.findById(3)));
        productList.add(new Product(++id, "Tu Lang toshiba", 200.0, 100, categoryService.findById(4)));
    }

    @Override
    public List<Product> showAll() {
        return productList;
    }

    @Override
    public void add(Product object) {
        object.setId(++id);
        int catId = object.getCategory().getId();
        Category category = categoryService.findById(catId);
        object.setCategory(category);
        productList.add(object);
    }

    @Override
    public void edit(int id, Product object) {
    for (Product product : productList){
        if (product.getId() == id){
            product.setName(object.getName());
            product.setPrice(object.getPrice());
            product.setQuantity(object.getQuantity());
            product.setCategory(object.getCategory());
        }
    }
    }

    @Override
    public void delete(int id) {
        productList.remove(findById(id));
    }

    @Override
    public Product findById(int id) {
        for (Product product:productList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
