package com.hai.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer" )
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
}


