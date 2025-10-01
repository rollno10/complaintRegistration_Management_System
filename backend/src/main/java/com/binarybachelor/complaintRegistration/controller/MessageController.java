package com.binarybachelor.complaintRegistration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.binarybachelor.complaintRegistration.service.MessageService;
import com.binarybachelor.complaintRegistration.entity.Message;

@RestController
@RequestMapping("/messages")
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Map<String,String> body){

        Long senderId = Long.valueOf(body.get("senderId"));
        Long complaintId = Long.valueOf(body.get("complaintId"));
        String text = body.get("text");

        return ResponseEntity.ok(messageService.sendMessage(senderId,complaintId,text));
    }

    @GetMapping("/{complaintId}")
    public ResponseEntity<List<Message>> getMessage(@PathVariable Long complaintId){

        return ResponseEntity.ok(messageService.getMessage(complaintId));
    }
}
