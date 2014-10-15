package org.wayfinder.entity;

import javax.persistence.*;

/**
 * Created by Иван on 12.10.14.
 */

@Entity
@Table(name = "USER_ENTITY")
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLES")
    private String roles;

    public UserEntity(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles=roles;
    }

    public UserEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
