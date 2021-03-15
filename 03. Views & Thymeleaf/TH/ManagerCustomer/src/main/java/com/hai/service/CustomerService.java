package com.hai.service;

import com.hai.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {

    private static Map<Integer, Customer> customers;
    static int id = 0;
    static {
        customers = new HashMap<>();
        customers.put(++id, new Customer(id, "John", "john@codegym.vn", "Hanoi"));
        customers.put(++id, new Customer(id, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(++id, new Customer(id, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(++id, new Customer(id, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(++id, new Customer(id, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(++id, new Customer(id, "Rose", "rose@codegym.vn", "Newyork"));
    }

    public List showAll(){
       return new ArrayList<>(customers.values());
    }

    public void save(Customer object){
        customers.put(object.getId(),object);
    }

    public Customer findById(int id) {
        return customers.get(id);
    }

    public void update(int id, Customer customer) {
        customers.put(id, customer);

    }

    public Customer remove(int id){
        Customer remove = customers.remove(id);
        return remove;
    }
}
