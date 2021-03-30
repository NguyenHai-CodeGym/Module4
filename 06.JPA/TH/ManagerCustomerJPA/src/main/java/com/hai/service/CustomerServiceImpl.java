package com.hai.service;

import com.hai.model.Customer;
import com.hai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService<Customer>{


    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        customerRepository.saveOrUpdate(customer);
    }

    @Override
    public void remove(Long id){
        customerRepository.remove(id);
    }
}
