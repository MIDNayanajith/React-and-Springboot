package com._6.AssignmentApplication.service;

import com._6.AssignmentApplication.domain.Assignment;
import com._6.AssignmentApplication.domain.User;
import com._6.AssignmentApplication.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepo;
    public Assignment save(User user) {
        Assignment assignment = new Assignment();
        assignment.setStatus("Needs to be Submitted");
        assignment.setUser(user);

        return assignmentRepo.save(assignment);
    }

    public Set<Assignment> findByUser(User user) {
        return assignmentRepo.findByUser(user);
    }

    public Optional<Assignment> findById(Long assignmentId) {
       return assignmentRepo.findById(assignmentId);
    }

    public Assignment save(Assignment assignment) {
        return assignmentRepo.save(assignment);
    }
}
