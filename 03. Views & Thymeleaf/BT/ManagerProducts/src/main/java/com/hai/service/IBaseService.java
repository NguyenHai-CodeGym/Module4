package com.hai.service;

import java.util.List;

public interface IBaseService<E> {

    List<E> showAll();

    void add(E object);

    void edit(int id, E object);

    void delete(int id);

    E findById(int id);
}
