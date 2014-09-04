/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartlaundry.domain;

import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author 212199587
 */
@Embeddable
public class Demographic {

    private String gender;
    private String race;
    private Date dateOfBirth;

    private Demographic() {
    }

    private Demographic(Builder build) {
        this.dateOfBirth = build.dateOfBirth;
        this.gender = build.gender;
        this.race = build.race;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    

    public static class Builder {

        private String gender;
        private String race;
        private Date dateOfBirth;

        public Builder(String gender) {
            this.gender = gender;

        }

        public Builder race(String race) {
            this.race = race;
            return this;
        }

        public Demographic build() {
            return new Demographic(this);
        }

        public Builder demographic(Demographic build) {
            this.dateOfBirth = build.dateOfBirth;
            this.gender = build.gender;
            this.race = build.race;
            return this;
        }
    }
}
