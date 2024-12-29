package com._6.AssignmentApplication.service;

import com._6.AssignmentApplication.repository.UserRepository;
import com._6.AssignmentApplication.util.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com._6.AssignmentApplication.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Optional<User>userOpt = userRepo.findByUserName(username);


       return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid Credential"));

    }
}
