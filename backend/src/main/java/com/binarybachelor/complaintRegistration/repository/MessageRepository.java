package com.binarybachelor.complaintRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarybachelor.complaintRegistration.entity.Message;
import com.binarybachelor.complaintRegistration.entity.Complaint;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
    List<Message> findByComplaintOrderByCreatedAtAsc(Complaint complaint);

    @Modifying
    @Transactional
    @Query("DELETE FROM Message m WHERE m.complaint.complaintId = :complaintId")
    void deleteByComplaintId(@Param("complaintId") Long complaintId);
}

