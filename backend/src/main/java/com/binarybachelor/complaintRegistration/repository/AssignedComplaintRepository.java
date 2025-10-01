package com.binarybachelor.complaintRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.binarybachelor.complaintRegistration.entity.AssignedComplaint;
import com.binarybachelor.complaintRegistration.entity.User;

import jakarta.transaction.Transactional;

import java.util.List;

public interface AssignedComplaintRepository extends JpaRepository<AssignedComplaint,Long>{
    
    @Query("""
    SELECT ac FROM AssignedComplaint ac
    JOIN FETCH ac.complaint c
    JOIN FETCH c.user u
    WHERE ac.agent = :agent
    """)
    List<AssignedComplaint> findByAgentWithComplaintAndUser(@Param("agent") User agent);

    @Modifying
    @Transactional
    @Query("DELETE FROM AssignedComplaint m WHERE m.complaint.complaintId = :complaintId")
    void deleteByComplaintId(@Param("complaintId") Long complaintId);
}
