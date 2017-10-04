package com.example.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class UserEntity implements Serializable{
    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
    //@Column(name="ROLE_ID")
    //private Integer roleId;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ROLE_ID", nullable=false)
    private UserRoleEntity userRole;
    @Column(name="NAME")
    private String name;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;

    public UserEntity (){

    }

    public UserEntity(Integer id, String name, String email, String password, UserRoleEntity userRole) {
        this.id = id;
        this.userRole = userRole;
        //this.roleId = roleId;
        this.name = name;
        this.email = email;
        this.password = password;
    }// select u.name, ur.role from user u, user_role ur where u.role_id = ur.id

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   // public Integer getRoleId() {
   //     return roleId;
    //}

   // public void setRoleId(Integer role_id) {
   //     this.roleId = role_id;
   // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleEntity getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEntity userRole) {
        this.userRole = userRole;
    }
}