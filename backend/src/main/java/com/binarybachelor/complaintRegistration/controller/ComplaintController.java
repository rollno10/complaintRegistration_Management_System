package com.binarybachelor.complaintRegistration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binarybachelor.complaintRegistration.entity.Complaint;
import com.binarybachelor.complaintRegistration.service.ComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;
    
    @PostMapping("/{userId}")
    public ResponseEntity<String> createComplaint(@PathVariable Long userId ,
                                                  @RequestBody Complaint complaint){
        return ResponseEntity.ok(complaintService.createComplaint(userId,complaint));
        
    }

    @GetMapping("/status/{userId}")
    public ResponseEntity<List<Complaint>> getUserComplaint(@PathVariable Long userId){
        
        return ResponseEntity.ok(complaintService.getUserComplaint(userId));
    }

    @GetMapping("/status")
    public ResponseEntity<List<Complaint>> getAllComplaint(){

        return ResponseEntity.ok(complaintService.getAllComplaint());
    }

    @PutMapping("/{complaintId}")
    public ResponseEntity<Complaint> updateComplaintStatus(@PathVariable Long complaintId,
                                                           @RequestBody Map<String,String> body){
        return ResponseEntity.ok(complaintService.updateComplaintStatus(complaintId, body.get("status")));
    }
}
