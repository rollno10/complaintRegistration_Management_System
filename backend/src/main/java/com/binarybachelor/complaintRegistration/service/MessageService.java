package com.binarybachelor.complaintRegistration.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.binarybachelor.complaintRegistration.entity.User;
import com.binarybachelor.complaintRegistration.entity.Complaint;
import com.binarybachelor.complaintRegistration.entity.Message;
import com.binarybachelor.complaintRegistration.repository.UserRepository;
import com.binarybachelor.complaintRegistration.repository.ComplaintRepository;
import com.binarybachelor.complaintRegistration.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(Long senderId, Long complaintId, String text){
        
        User sender = userRepository.findByUserId(senderId)
            .orElseThrow(() -> new RuntimeException("Sender not found"));

        Complaint complaint = complaintRepository.findByComplaintId(complaintId)
            .orElseThrow(() -> new RuntimeException("Message compliant not found"));

        Message message = new Message();
        message.setSender(sender);
        message.setComplaint(complaint);
        message.setText(text);

        messageRepository.save(message);
        return message;
    }

    public List<Message> getMessage(Long complaintId){

        Complaint complaint = complaintRepository.findByComplaintId(complaintId)
            .orElseThrow(() -> new RuntimeException("Message compliant not found"));

        return messageRepository.findByComplaintOrderByCreatedAtAsc(complaint);
    }
}
