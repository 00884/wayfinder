package org.wayfinder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Иван on 12.10.14.
 */


public class UserEntity{

    private String username;

    private String password;

    private String roles;

    public UserEntity(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles=roles;
    }

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
