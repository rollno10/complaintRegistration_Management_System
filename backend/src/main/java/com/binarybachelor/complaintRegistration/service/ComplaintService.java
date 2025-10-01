package com.binarybachelor.complaintRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.binarybachelor.complaintRegistration.entity.Complaint;
import com.binarybachelor.complaintRegistration.repository.ComplaintRepository;
import com.binarybachelor.complaintRegistration.repository.UserRepository;
import com.binarybachelor.complaintRegistration.entity.User;

import java.util.List;

@Service
public class ComplaintService {
    
    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    // Create Complaint
    public String createComplaint(Long userId , Complaint complaint){

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        complaint.setUser(user); 
        complaintRepository.save(complaint);
        return "Complaint is created";
    }

    // Fetch User Complaint
    public List<Complaint> getUserComplaint(Long userId){

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return complaintRepository.findByUser(user);
    }

    // Fetch All Complaint
    public List<Complaint> getAllComplaint(){

        return complaintRepository.findAll();
    }

    // Update Complaint Status
    public Complaint updateComplaintStatus(Long complaintId,String status){

        Complaint complaint = complaintRepository.findByComplaintId(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }
}
