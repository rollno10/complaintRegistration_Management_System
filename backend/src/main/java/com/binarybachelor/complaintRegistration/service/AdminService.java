package com.binarybachelor.complaintRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarybachelor.complaintRegistration.entity.User;

import com.binarybachelor.complaintRegistration.repository.ComplaintRepository;
import com.binarybachelor.complaintRegistration.repository.UserRepository;
import com.binarybachelor.complaintRegistration.repository.MessageRepository;
import com.binarybachelor.complaintRegistration.repository.AssignedComplaintRepository;

@Service
public class AdminService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignedComplaintRepository assignedComplaintRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ComplaintRepository complaintRepository;
    
    public User getAgent(Long userId){

        User agent = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Agent not Found"));
        return agent;
    }

    public List<User> getAllUser(String userRole){

        return userRepository.findByUserRole(userRole);
    }

    public String deleteUser(Long userId){

        userRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("User not Found"));
        List<Long> complaintId = complaintRepository.findComplaintIdByUserId(userId);
        for(Long id : complaintId){
        messageRepository.deleteByComplaintId(id);
        assignedComplaintRepository.deleteByComplaintId(id);
        }
        complaintRepository.deleteByUserId(userId);
        userRepository.deleteById(userId);
        return ("User get deleted");
    }

    public String updateUser(Long userId, String name, String email, String phone){

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not Found"));
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        userRepository.save(user);
        return ("User data get updated");
    }
}
