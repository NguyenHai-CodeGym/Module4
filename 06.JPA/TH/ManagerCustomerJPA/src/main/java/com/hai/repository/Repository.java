package com.hai.repository;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.util.List;

public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void saveOrUpdate(T model);

    void remove(Long id);
}
