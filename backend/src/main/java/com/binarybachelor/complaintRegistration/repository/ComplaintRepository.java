package com.binarybachelor.complaintRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarybachelor.complaintRegistration.entity.Complaint;
import com.binarybachelor.complaintRegistration.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface ComplaintRepository extends JpaRepository<Complaint,Long>{
    
    List<Complaint> findByUser(User user);
    Optional<Complaint> findByComplaintId(Long complaintId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Complaint c WHERE c.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);

    @Query("SELECT complaintId FROM Complaint c WHERE c.user.id = :userId")
    List<Long> findComplaintIdByUserId(@Param("userId") Long userId);
}
