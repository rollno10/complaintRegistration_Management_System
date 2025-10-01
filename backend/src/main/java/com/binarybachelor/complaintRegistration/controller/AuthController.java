package com.binarybachelor.complaintRegistration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.binarybachelor.complaintRegistration.entity.User;
import com.binarybachelor.complaintRegistration.service.AuthService;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class AuthController {
    
    @Autowired
    public AuthService authService;
    
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user){
        User saveUser = authService.signup(user);
        return ResponseEntity.ok(saveUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = body.get("password");
        User user = authService.login(email, password);
        return ResponseEntity.ok(user);
    }
}
