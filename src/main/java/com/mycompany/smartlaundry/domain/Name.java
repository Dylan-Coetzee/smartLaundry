/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.smartlaundry.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author 212199587
 */
@Embeddable
public class Name {
    private String firstName;
    private String lastName;

    public Name() {
    }
    
    public Name(Builder build) {
        this.firstName= build.firstName;
        this.lastName= build.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public static class Builder{
          private String firstName;
           private String lastName;
           public Builder(String first){
               this.firstName=first;
           }
           public Builder lastname(String last){
               this.lastName=last;
               return this;
           }
           public Name build(){
               return new Name(this);
           }
          public Builder copier(Name build){
                this.firstName= build.firstName;
                 this.lastName= build.lastName;
                 return this;
          }
    }
}
