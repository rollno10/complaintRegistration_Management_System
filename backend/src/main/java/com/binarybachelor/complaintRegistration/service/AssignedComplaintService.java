package com.binarybachelor.complaintRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.binarybachelor.complaintRegistration.entity.Complaint;
import com.binarybachelor.complaintRegistration.entity.AssignedComplaint;
import com.binarybachelor.complaintRegistration.repository.ComplaintRepository;
import com.binarybachelor.complaintRegistration.repository.AssignedComplaintRepository;
import com.binarybachelor.complaintRegistration.repository.UserRepository;
import com.binarybachelor.complaintRegistration.entity.User;

@Service
public class AssignedComplaintService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private AssignedComplaintRepository assignedComplaintRepository;

    public String assignComplaint(Long agentId, Long complaintId, String status){

        User agent = userRepository.findByUserId(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found"));
        Complaint complaint = complaintRepository.findByComplaintId(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        AssignedComplaint assignedComplaint = new AssignedComplaint();
        assignedComplaint.setAgent(agent);
        assignedComplaint.setComplaint(complaint);
        assignedComplaint.setStatus(status);

        assignedComplaintRepository.save(assignedComplaint);
        return "Complaint Assigned to the Agent";
    }

    public List<AssignedComplaint> getAssignedComplaint(Long agentId){

        User agent = userRepository.findByUserId(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found"));
        List<AssignedComplaint> assignedComplaint = assignedComplaintRepository.findByAgentWithComplaintAndUser(agent);
        return assignedComplaint;
    }
}