package com._6.AssignmentApplication.repository;

import com._6.AssignmentApplication.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {

}
