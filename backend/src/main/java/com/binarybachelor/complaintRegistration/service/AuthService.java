package com.binarybachelor.complaintRegistration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarybachelor.complaintRegistration.entity.User;
import com.binarybachelor.complaintRegistration.repository.UserRepository;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    //User Register
    public User signup(User user){
        return userRepository.save(user);
    }

    public User login(String email,String password){
        Optional<User> userOpt = userRepository.findByEmail(email);
        
        if(userOpt.isPresent()){

            User user = userOpt.get();

            if(user.getPassword().equals(password)){
                return user;
            }else{
                throw new RuntimeException("invalid Password");
            }
        }else{
            throw new RuntimeException("user not found");
        }
    }
}
