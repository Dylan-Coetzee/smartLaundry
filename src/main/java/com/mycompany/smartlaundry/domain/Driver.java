/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartlaundry.domain;

import java.io.Serializable;
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
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Name name;
    @Embedded
    private Contact contact;
    @Embedded
    private Demographic demographic;
    private String licenseNum;

    private Driver() {
    }

    private Driver(Builder builder) {

        this.contact = builder.contact;
        this.demographic = builder.demographic;
        this.name = builder.name;
        this.licenseNum = builder.licenseNum;
    }

    public static class Builder {

        private Long id;
        private Name name;
        private Contact contact;
        private Demographic demographic;
        private String licenseNum;

        public Builder(String licenseNum) {
            this.licenseNum = licenseNum;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder contact(Contact cont) {
            this.contact = cont;
            return this;
        }

        public Builder demographics(Demographic demo) {
            this.demographic = demo;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }

        public Builder driver(Driver builder) {
            this.contact = builder.contact;
            this.demographic = builder.demographic;
            this.name = builder.name;
            this.licenseNum = builder.licenseNum;
            return this;
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

    public String getLicenseNum() {
        return licenseNum;
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
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.smartlaundry.domain.Driver[ id=" + id + " ]";
    }

}
