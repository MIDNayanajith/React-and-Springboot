package com._6.AssignmentApplication.service;

import com._6.AssignmentApplication.domain.Assignment;
import com._6.AssignmentApplication.domain.User;
import com._6.AssignmentApplication.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
