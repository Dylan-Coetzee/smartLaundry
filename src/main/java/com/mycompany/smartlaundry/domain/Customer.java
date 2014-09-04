/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartlaundry.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Dylan
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @Embedded
    private Name name;
    @Embedded
    private Contact contact;
    @Embedded
    private Demographic demographic;
    private String allergy;
    @OneToMany( cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "customerNumber")
    List<CustomerOrder> orders;

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.allergy = builder.allergy;
        this.contact = builder.contact;
        this.demographic = builder.demographic;
        this.name = builder.name;
        this.orders = builder.orders;
    }

    public static class Builder {

        private Long customerId;
        private String allergy;
        private Name name;
        private Contact contact;
        private Demographic demographic;
        private List<CustomerOrder> orders;

        public Builder(String allergy) {
            this.allergy = allergy;
        }

        public Builder orders(List<CustomerOrder> order){
            this.orders = order;
            return this;
        }
        public Builder customer_id(Long customer_id) {
            this.customerId = customer_id;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder demographic(Demographic demo) {
            this.demographic = demo;
            return this;
        }

        public Builder Customer(Customer builder) {
            this.customerId = builder.customerId;
            this.allergy = builder.allergy;
            this.contact = builder.contact;
            this.demographic = builder.demographic;
            this.name = builder.name;
            this.orders = builder.orders;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getAllergy() {
        return allergy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.customerId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerId, other.customerId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customerId + '}';
    }
}
