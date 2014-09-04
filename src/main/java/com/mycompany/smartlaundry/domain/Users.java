/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartlaundry.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
 * @author DARLINGTON
 */
@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerNumber")
    List<CustomerOrder> orders;
    private String username;
    private String password;

    private Users() {
    }

    private Users(Builder builder) {
        this.id = builder.id;
        this.orders = builder.orders;
        this.password = builder.password;
        this.username = builder.username;
    }

    public static class Builder {

        private Long id;
        List<CustomerOrder> orders;
        private String username;
        private String password;

        public Builder(long id) {
            this.id = id;
        }

        public Builder orders(List<CustomerOrder> order) {
            this.orders = order;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Users build() {
            return new Users(this);
        }

        public Builder users(Users builder) {
            this.id = builder.id;
            this.orders = builder.orders;
            this.password = builder.password;
            this.username = builder.username;
            return this;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.smartlaundry.domain.Users[ id=" + id + " ]";
    }

}
