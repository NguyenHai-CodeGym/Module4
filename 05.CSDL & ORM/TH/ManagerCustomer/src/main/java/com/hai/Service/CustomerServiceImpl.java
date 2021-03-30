package com.hai.Service;

import com.hai.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerServiceImpl implements CustomerService<Customer> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer ").list();
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class,id);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(customer);

    }

    @Override
    public List<Customer> saveList(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exits(int id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Integer> list) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Customer customer = session.get(Customer.class,id);
    session.remove(customer);
    session.getTransaction().commit();
    }

    @Override
    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
    }

    @Override
    public void delete(List<Customer> list) {

    }

    @Override
    public void deleteAll() {

    }
}
