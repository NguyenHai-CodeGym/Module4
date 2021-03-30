package com.hai.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private Long provinceID;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "province")
    private List<Customer> customers;

    public Province() {
    }

    public Province(Long provinceID, String name, List<Customer> customers) {
        this.provinceID = provinceID;
        this.name = name;
        this.customers = customers;
    }

    public Long getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Long provinceID) {
        this.provinceID = provinceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceID=" + provinceID +
                ", name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
