package com.hai.repository;

import com.hai.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.*;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager em;



    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Customer findById(Long id) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    @Transactional
    public void saveOrUpdate(Customer model) {
        if (model.getId() == null) {
            em.persist(model);
        } else {
            em.merge(model);
        }

    }

    @Override
    @Transactional
    public void remove(Long id){
       em.remove(findById(id));
    }
}
