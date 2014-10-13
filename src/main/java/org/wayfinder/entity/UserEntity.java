package org.wayfinder.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Иван on 12.10.14.
 */

@Entity
@Table(name="user")
public class UserEntity{

    @Id
    @Column(name = "username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="roles")
    private String roles;

    public UserEntity(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles=roles;
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
