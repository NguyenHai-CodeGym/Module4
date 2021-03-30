package com.hai.model;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
   private LinkedHashMap<Product,Integer> carts = new LinkedHashMap<>();

   private double total;

    public Cart() {
    }

    public Cart(LinkedHashMap<Product, Integer> carts, double total) {
        this.carts = carts;
        this.total = total;
    }

    public LinkedHashMap<Product, Integer> getCarts() {
        return carts;
    }

    public void setCarts(LinkedHashMap<Product, Integer> carts) {
        this.carts = carts;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "carts=" + carts +
                ", total=" + total +
                '}';
    }
}
