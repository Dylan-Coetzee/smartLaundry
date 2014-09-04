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
public class DeliveryZone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String zone;
    private double amount;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    List<DeliveryLog> deliveryLogs;
    
    public Long getId() {
        return id;
    }

    public String getZone() {
        return zone;
    }

    public double getAmount() {
        return amount;
    }

    public List<DeliveryLog> getDeliveryLogs() {
        return deliveryLogs;
    }
    
    private DeliveryZone(Builder builder)
    {
        id = builder.id;
        zone = builder.zone;
        amount = builder.amount;
    }
    
    public static class Builder{
    private Long id;
    private String zone;
    private double amount;
    List<DeliveryLog> deliveryLogs;
    
        public Builder(String zone) {
            this.zone = zone;
        }
        
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        
        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }
        
        public Builder deliveryLog(List<DeliveryLog> deliverylog) {
            deliveryLogs = deliverylog;
            return this;
        }
        
        public Builder DeliveryZone(DeliveryZone deliveryZone){
            id = deliveryZone.getId();
            zone = deliveryZone.getZone();
            amount = deliveryZone.getAmount();
            deliveryLogs = deliveryZone.getDeliveryLogs();
            return this;
        }
        
        public DeliveryZone build(){
            return new DeliveryZone(this);
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
        if (!(object instanceof DeliveryZone)) {
            return false;
        }
        DeliveryZone other = (DeliveryZone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.smartlaundry.domain.DeliveryZone[ id=" + id + " ]";
    }
    
}
