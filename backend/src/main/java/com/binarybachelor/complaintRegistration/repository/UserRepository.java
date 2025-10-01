package com.binarybachelor.complaintRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarybachelor.complaintRegistration.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    List<User> findByUserRole(String userRole);
    Optional<User> findByUserId(Long userId);
}
