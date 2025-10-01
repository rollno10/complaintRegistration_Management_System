package com.binarybachelor.complaintRegistration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "AssignedComplaints")
public class AssignedComplaint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name="complaintId",nullable = false)
    private Complaint complaint;

    @ManyToOne
    @JoinColumn(name="agentId",nullable = false)
    private User agent;


    public Long getId() {return id;}

    public String getStatus() {return status;}
    public void setStatus(String status){ this.status = status;}

    public Complaint getComplaint() {return complaint;}
    public void setComplaint(Complaint complaint) { this.complaint = complaint;}

    public User getAgent() {return agent;}
    public void setAgent(User agent) {this.agent = agent;}

}
