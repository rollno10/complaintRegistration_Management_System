package com.binarybachelor.complaintRegistration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binarybachelor.complaintRegistration.entity.User;
import com.binarybachelor.complaintRegistration.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/{role}")
    public ResponseEntity<List<User>> getAllUser(@PathVariable String role){
        
        return ResponseEntity.ok(adminService.getAllUser(role));
    }

    @GetMapping("/fetch/{userId}")
    public ResponseEntity<User> getAgent(@PathVariable Long userId){
        
        return ResponseEntity.ok(adminService.getAgent(userId));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){

        return ResponseEntity.ok(adminService.deleteUser(userId));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId,
                                             @RequestBody Map<String,String> body){
        String name = body.get("name");
        String phone = body.get("phone");
        String email = body.get("email");

        return ResponseEntity.ok(adminService.updateUser(userId,name,email,phone));
    }
}
