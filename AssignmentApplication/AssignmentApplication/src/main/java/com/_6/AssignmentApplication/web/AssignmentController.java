package com._6.AssignmentApplication.web;

import com._6.AssignmentApplication.domain.Assignment;
import com._6.AssignmentApplication.domain.User;
import com._6.AssignmentApplication.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("")
    public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user){
        Assignment newAssignment = assignmentService.save(user);

        return ResponseEntity.ok(newAssignment);
    }
    @GetMapping("")
    public  ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user){
        Set<Assignment> assignmentByUser = assignmentService.findByUser(user);
        return ResponseEntity.ok(assignmentByUser);
    }

    @GetMapping("{assignmentId}")
    public  ResponseEntity<?> getAssignments(@PathVariable Long assignmentId, @AuthenticationPrincipal User user){
        Optional<Assignment> assignmentOpt = assignmentService.findById(assignmentId);
        return ResponseEntity.ok(assignmentOpt.orElse(new Assignment()));
    }
}
