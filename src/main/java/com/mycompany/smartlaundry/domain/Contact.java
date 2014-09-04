/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartlaundry.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author 212199587
 */
@Embeddable
public class Contact implements Serializable {

    private String phoneNumber;
    private String cellNumber;
    private String email;
    private String address;

    private Contact() {
    }

    private Contact(Builder build) {
        this.cellNumber = build.cellNumber;
        this.phoneNumber = build.phoneNumber;
        this.address = build.address;
        this.email = build.email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {

        private String phoneNumber;
        private String cellNumber;
        private String email;
        private String address;

        public Builder(String cell) {
            this.cellNumber = cell;
        }

        public Builder phone(String phone) {
            this.phoneNumber = phone;
            return this;
        }
       
        public Builder address(String addr){
            this.address = addr;
            return this;
        }
        public Builder email(String email){
            this.email  =  email;
            return this;
        }
        public Contact build() {
            return new Contact(this);
        }

        public Builder contact(Contact build) {
            this.cellNumber = build.cellNumber;
            this.phoneNumber = build.phoneNumber;
            this.address = build.address;
            this.email = build.email;
            return this;
        }
    }

}
