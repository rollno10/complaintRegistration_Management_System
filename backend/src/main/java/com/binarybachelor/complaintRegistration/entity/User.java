package com.binarybachelor.complaintRegistration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userRole;


    public Long getUserId() {return userId;}

    public String getName() {return name;}
    public void setName(String name){ this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getUserRole() {return userRole;}
    public void setUserRole(String userRole) {this.userRole = userRole;}

}