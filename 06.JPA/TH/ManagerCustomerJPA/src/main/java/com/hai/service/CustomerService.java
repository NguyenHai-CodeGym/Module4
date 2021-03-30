package com.hai.service;


import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.util.List;

public interface CustomerService<T> {

    List<T> findAll();

    T findById(Long id);

    void saveOrUpdate(T t);

    void remove(Long id);
}
