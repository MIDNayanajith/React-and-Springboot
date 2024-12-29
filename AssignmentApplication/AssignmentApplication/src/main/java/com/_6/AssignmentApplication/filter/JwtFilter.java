package com._6.AssignmentApplication.filter;

import com._6.AssignmentApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtFilter {

    @Autowired
    private UserRepository userRepo;
}
