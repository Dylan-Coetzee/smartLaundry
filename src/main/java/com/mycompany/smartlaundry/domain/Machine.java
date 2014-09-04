/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.smartlaundry.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Dylan
 */
@Entity
public class Machine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private int duration;
    private String machine_type;
    private String last_service_date;
    private int capacity;
    @ManyToOne
    private Load load;

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public int getDuration() {
        return duration;
    }

    public String getMachine_type() {
        return machine_type;
    }

    public String getLast_service_date() {
        return last_service_date;
    }

    public int getCapacity() {
        return capacity;
    }
    
    private Machine(Builder builder){
        id = builder.id;
        make = builder.make;
        duration = builder.duration;
        machine_type = builder.machine_type;
        last_service_date = builder.last_service_date;
        capacity = builder.capacity;
    }
    
    public static class Builder{
        private Long id;
        private String make;
        private int duration;
        private String machine_type;
        private String last_service_date;
        private int capacity;
        
        public Builder(String make){
            this.make = make;
        }
        
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        
        public Builder duration(int duration){
            this.duration = duration;
            return this;
        }
        
        public Builder machine_type(String machine_type){
            this.machine_type = machine_type;
            return this;
        }
        
        public Builder last_service_date(String last_service_date){
            this.last_service_date = last_service_date;
            return this;
        }
        
        public Builder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }
        
         public Builder Machine(Machine machine){
            id = machine.getId();
            make = machine.getMake();
            duration = machine.getDuration();
            machine_type = machine.getMachine_type();
            last_service_date = machine.getLast_service_date();
            capacity = machine.getCapacity();
            return this;
        }
        
        public Machine build(){
            return new Machine(this);
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
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.smartlaundry.domain.Machine[ id=" + id + " ]";
    }
    
}
