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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Dylan
 */
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private double rate;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<OrderItem> orderItems;
   
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getRate() {
        return rate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    private Category(Builder builder){
        id = builder.id;
        type = builder.type;
        rate = builder.rate;
        orderItems = builder.orderItems;
    }
    
    public static class Builder{
        private Long id;
        private String type;
        private double rate;
        private List<OrderItem> orderItems;
        
        public Builder(String type){
            this.type = type;
        }
        
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        
        public Builder rate(double rate){
            this.rate = rate;
            return this;
        }
        
        public Builder orderItems(List<OrderItem> orderItem){
            this.orderItems = orderItem;
            return this;
        }
        
        public Builder Category(Category category){
            id = category.getId();
            type = category.getType();
            rate = category.getRate();
            orderItems = category.getOrderItems();
            return this;
        }
        
        public Category build(){
            return new Category(this);
        }
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
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.smartlaundry.domain.Category[ id=" + id + " ]";
    }
    
}
