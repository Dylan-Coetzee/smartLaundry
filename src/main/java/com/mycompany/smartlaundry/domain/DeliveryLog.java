/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartlaundry.domain;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author DARLINGTON
 */
@Entity
public class DeliveryLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Calendar deliveryTime;
    @Embedded
    private Contact contact;
    private String delivered;

    private DeliveryLog() {
    }

    private DeliveryLog(Builder builder) {
        this.contact = builder.contact;
        this.delivered = builder.delivered;
        this.deliveryTime = builder.deliveryTime;
        this.id = builder.id;
    }

    public static class Builder {

        private Long id;
        private Calendar deliveryTime;
        private Contact contact;
        private String delivered;

        public Builder(String delivered) {
            this.delivered = delivered;
        }

        public Builder deliveryTime(Calendar dt) {
            this.deliveryTime = dt;
            return this;
        }

        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public DeliveryLog build() {
            return new DeliveryLog(this);
        }

        public Builder deliveryLog(DeliveryLog builder) {
            this.contact = builder.contact;
            this.delivered = builder.delivered;
            this.deliveryTime = builder.deliveryTime;
            this.id = builder.id;
            return this;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Calendar getDeliveryTime() {
        return deliveryTime;
    }

    public Contact getContact() {
        return contact;
    }

    public String getDelivered() {
        return delivered;
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
        if (!(object instanceof DeliveryLog)) {
            return false;
        }
        DeliveryLog other = (DeliveryLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.DeliveryLog[ id=" + id + " ]";
    }

}
