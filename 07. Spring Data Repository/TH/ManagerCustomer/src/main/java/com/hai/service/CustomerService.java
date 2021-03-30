package com.hai.service;

import com.hai.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;



public interface CustomerService {


     Page<Customer> findAll(Pageable pageable);

     Page<Customer> findAllByNameContaining(String name, Pageable pageable);


     Optional<Customer> findById(Long id);


     void save(Customer customer) ;


     void remove(Long id) ;
}
