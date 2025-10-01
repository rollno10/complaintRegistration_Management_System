package com.binarybachelor.complaintRegistration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.List;

import com.binarybachelor.complaintRegistration.service.AssignedComplaintService;
import com.binarybachelor.complaintRegistration.entity.AssignedComplaint;

@RestController
@RequestMapping("/assigned")
public class AssignedComplaintController {

    @Autowired
    private AssignedComplaintService assignedComplaintService;

    @PostMapping
    public ResponseEntity<String> assignComplaint(@RequestBody Map<String,String> body){
        
        Long complaintId = Long.valueOf(body.get("complaintId"));
        Long agentId = Long.valueOf(body.get("agentId"));
        String status = body.getOrDefault("status","Assigned");

        String assigned = assignedComplaintService.assignComplaint(agentId,complaintId,status);
        return ResponseEntity.ok(assigned);
    }

    @GetMapping("/{agentId}")
    public ResponseEntity<List<AssignedComplaint>> getAssignedComplaint(@PathVariable Long agentId){
        
        return ResponseEntity.ok(assignedComplaintService.getAssignedComplaint(agentId));
    }
    
}
