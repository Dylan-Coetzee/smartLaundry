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
public class Load implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long item_id;
    private String description;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    List<Machine> machines;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    List<OrderItem> orderItems;

    public Long getId() {
        return id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public String getDescription() {
        return description;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    private Load(Builder builder){
        id = builder.id;
        item_id =  builder.id;
        description = builder.description;
        orderItems = builder.orderItems;
    }
    
    private static class Builder{
        
        private Long id;
        private Long item_id;
        private String description; 
        private List<Machine> machines;
        private List<OrderItem> orderItems;
        
        public Builder(Long item_id) {
            this.item_id = item_id;
        }
        
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        
        public Builder description(String description){
            this.description = description;
            return this;
        }
        
        public Builder machines(List<Machine> machine) {
            machines = machine;
            return this;
        }
        
        public Builder orderItems(List<OrderItem> orderItem) {
            orderItems = orderItem;
            return this;
        }
        
        public Builder Load(Load load){
            id = load.getId();
            item_id = load.getItem_id();
            description = load.getDescription();
            orderItems = load.getOrderItems();
            return this;
        }
        
        public Load build(){
            return new Load(this);
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
        if (!(object instanceof Load)) {
            return false;
        }
        Load other = (Load) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.smartlaundry.domain.Load[ id=" + id + " ]";
    }
    
}
