package com.edutask.api.repository;

import com.edutask.api.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    // Custom query to filter by course name (Useful for Step 9 bonus)
    List<Assignment> findByCourseNameContainingIgnoreCase(String courseName);
}