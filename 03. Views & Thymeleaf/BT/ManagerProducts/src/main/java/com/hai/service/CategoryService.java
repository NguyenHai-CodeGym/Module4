package com.hai.service;

import com.hai.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements IBaseService<Category> {
    int id;
    List<Category> categoryList = new ArrayList<>();

    public CategoryService() {
        categoryList.add(new Category(0, "Laptop"));
        categoryList.add(new Category(0, "Tivi"));
        categoryList.add(new Category(0, "Smart Phone"));
        categoryList.add(new Category(0, "PC"));
        categoryList.add(new Category(0, "Other"));
    }

    @Override
    public List<Category> showAll() {
        return categoryList;
    }

    @Override
    public void add(Category object) {
        object.setId(++id);
        categoryList.add(object);
    }

    @Override
    public void edit(int id, Category object) {
        categoryList.set(id, object);
    }

    @Override
    public void delete(int id) {
        categoryList.remove(findById(id));
    }

    @Override
    public Category findById(int id) {
        return categoryList.get(id);
    }

}
