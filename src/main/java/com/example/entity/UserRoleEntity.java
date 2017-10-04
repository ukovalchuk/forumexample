package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_role")

public class UserRoleEntity implements Serializable{

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
    @Column(name="role")
    private String role;

    public UserRoleEntity() {
    }

    public UserRoleEntity(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
