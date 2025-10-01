package com.binarybachelor.complaintRegistration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String pincode;

    private String status;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;


    public Long getComplaintId() {return complaintId;}

    public String getCity() {return city;}
    public void setEmail(String city) { this.city = city;}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    public String getPincode() {return pincode;}
    public void setPincode(String pincode) {this.pincode = pincode;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public String getAddress(){return address;}
    public void SetAddress(String address){this.address = address;}

    public String getDescription() {return description;}
    public void SetDescription(String description){this.description = description;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}
}
