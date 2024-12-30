package com._6.AssignmentApplication.repository;

import com._6.AssignmentApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String UserName);

}
