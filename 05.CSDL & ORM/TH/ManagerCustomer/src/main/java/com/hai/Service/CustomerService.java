package com.hai.Service;
import java.util.List;



public interface CustomerService<T> {
    List<T> findAll();

    T findById(int id);

    void save(T t);

    List<T> saveList(List<T> ts);

    boolean exits(int id);

    List<T> findAll(List<Integer> list);

    int count();

    void delete(int id);

    void update(T t) ;

    void delete(List<T> list);

    void deleteAll();

}
