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
import javax.persistence.OneToMany;

/**
 *
 * @author DARLINGTON
 */
@Entity
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Users> users;

    private UserRoles() {

    }

    private UserRoles(Builder builder) {
        this.id = builder.id;
        this.roleName = builder.roleName;
        this.users = builder.users;
    }

    public static class Builder {

        private Long id;
        private String roleName;
        private List<Users> users;

        public Builder(String roleName) {
            this.roleName = roleName;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder users(List<Users> users) {
            this.users = users;
            return this;
        }

        public UserRoles build() {
            return new UserRoles(this);
        }

        public Builder userRoles(UserRoles builder) {
            this.id = builder.id;
            this.roleName = builder.roleName;
            this.users = builder.users;
            return this;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRoleName() {
        return roleName;
    }

    public List<Users> getUsers() {
        return users;
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
        if (!(object instanceof UserRoles)) {
            return false;
        }
        UserRoles other = (UserRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.smartlaundry.domain.UserRoles[ id=" + id + " ]";
    }

}
