/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartlaundry.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author DARLINGTON
 */
@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal fine;
    private String storage;
    private String collected;
    private Calendar tranDatetime;
    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private List<DeliveryLog> deliveryLog;
    @ManyToOne
    private Customer customer;

    private CustomerOrder(Builder build) {
        this.id = build.id;
        this.collected = build.collected;
        this.fine = build.fine;
        this.storage = build.storage;
        this.tranDatetime = build.tranDatetime;
        this.deliveryLog = build.deliveryLog;
        this.customer = build.customer;
    }

    private CustomerOrder() {
    }

    public static class Builder {

        private Long id;
        private BigDecimal fine;
        private String storage;
        private String collected;
        private Calendar tranDatetime;
        private Customer customer;
        private List<DeliveryLog> deliveryLog;

        public Builder(String storage) {
            this.storage = storage;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder fine(BigDecimal fine) {
            this.fine = fine;
            return this;
        }
        public Builder deliveryLog(List<DeliveryLog> logs){
            this.deliveryLog = logs;
            return this;
        }
        public Builder Customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public CustomerOrder build() {
            return new CustomerOrder(this);
        }

        public Builder customerOrder(CustomerOrder build) {
            this.id = build.id;
            this.collected = build.collected;
            this.fine = build.fine;
            this.storage = build.storage;
            this.tranDatetime = build.tranDatetime;
            this.deliveryLog = build.deliveryLog;
            this.customer =build.customer;
            return this;
        }
    }

    public List<DeliveryLog> getDeliveryLog() {
        return deliveryLog;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public String getStorage() {
        return storage;
    }

    public String getCollected() {
        return collected;
    }

    public Calendar getTrandatetime() {
        return tranDatetime;
    }

    public Customer getCustomer() {
        return customer;
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
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.CustomerOrder[ id=" + id + " ]";
    }

}
