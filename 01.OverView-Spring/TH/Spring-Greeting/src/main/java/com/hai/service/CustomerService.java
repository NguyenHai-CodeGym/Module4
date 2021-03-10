package com.hai.service;

import com.hai.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    static List<Customer> customerList = null;
    static int id = 0;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(++id,"Hai","email1@gmail.com","address1"));
        customerList.add(new Customer(++id,"PhuocBae","email2@gmail.com","address2"));
        customerList.add(new Customer(++id,"ThangBae","email3@gmail.com","address3"));
        customerList.add(new Customer(++id,"ThinhBae","email4@gmail.com","address4"));
        customerList.add(new Customer(++id,"TuBae","email5@gmail.com","address5"));
    }

    public List<Customer> showAll(){
        return customerList;
    }

    public Customer findById(int id){
        for (Customer c : customerList){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public void delete(int id){
        customerList.remove(findById(id));
    }

    public void addCustomer(Customer customer){
        customerList.add(new Customer(++id,customer.getName(),customer.getEmail(),customer.getAddress()));
    }

    public void editCustomer(Customer object){
        Customer customer = findById(object.getId());
        customer.setName(object.getName());
        customer.setEmail(object.getEmail());
        customer.setAddress(object.getAddress());
    }
}
