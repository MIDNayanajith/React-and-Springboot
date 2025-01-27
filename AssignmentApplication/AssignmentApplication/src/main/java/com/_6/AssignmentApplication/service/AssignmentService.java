package com._6.AssignmentApplication.service;

import com._6.AssignmentApplication.domain.Assignment;
import com._6.AssignmentApplication.domain.User;
import com._6.AssignmentApplication.enums.AssignmentStatusEnum;
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
        assignment.setStatus(AssignmentStatusEnum.PENDING_SUBMISSION.getStatus());
        assignment.setNumber(findNextAssignmentToSubmit(user));
        assignment.setUser(user);

        return assignmentRepo.save(assignment);
    }

    private Integer findNextAssignmentToSubmit(User user) {
        Set<Assignment> assignmentByUser = assignmentRepo.findByUser(user);
        if(assignmentByUser == null){
            return 1;
        }
        Optional<Integer> nextAssignmentOpt = assignmentByUser.stream().sorted((a1,a2) ->{
            if(a1.getNumber() == null) return 1;
            if(a2.getNumber() == null) return 1;
            return a2.getNumber().compareTo(a1.getNumber());
        })
                .map(assignment -> {
                    if( assignment.getNumber() == null )
                        return 1;
                    return assignment.getNumber() + 1;
                }).findFirst();
        return nextAssignmentOpt.orElse(1);
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
