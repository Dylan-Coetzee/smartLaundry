/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.smartlaundry.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Dylan
 */
@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String description;
    private Long cat_id;
    private double weight;
    @ManyToOne
    private Load load;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public double getWeight() {
        return weight;
    }

    public Load getLoad() {
        return load;
    }
    
    private OrderItem(Builder builder){
        id = builder.id;
        description = builder.description;
        cat_id = builder.cat_id;
        load = builder.load;
    }
    
    private static class Builder{
        private Long id;
        private String description;
        private Long cat_id;
        private Load load;
        
        public Builder(String description){
            this.description = description;
        }
        
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        
        public Builder cat_id(Long cat_id){
            this.cat_id = cat_id;
            return this;
        }
        
        public Builder load(Load load){
            this.load = load;
            return this;
        }
        
        public Builder OrderItem(OrderItem orderItem){
            id = orderItem.getId();
            description = orderItem.getDescription();
            cat_id = orderItem.getCat_id();
            load = orderItem.getLoad();
            return this;
        }
        
        public OrderItem build(){
            return new OrderItem(this);
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.smartlaundry.domain.OrderItem[ id=" + id + " ]";
    }
    
}
