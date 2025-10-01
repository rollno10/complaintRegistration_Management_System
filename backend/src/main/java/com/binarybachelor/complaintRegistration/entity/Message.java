package com.binarybachelor.complaintRegistration.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name="senderId",nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name="complaintId",nullable = false)
    private Complaint complaint;

    private final LocalDateTime createdAt = LocalDateTime.now();


    public Long getMessageId() {return message_id;}

    public String getText() {return text;}
    public void setText(String text){ this.text = text;}

    public Complaint getComplaint() {return complaint;}
    public void setComplaint(Complaint complaint) { this.complaint = complaint;}
    
    public User getSender(){return sender;}
    public void setSender(User sender){this.sender = sender;}
    
    public LocalDateTime getCreatedAt() {return createdAt;}
}
