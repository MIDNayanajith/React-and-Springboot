package com._6.AssignmentApplication.domain;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDate cohortStartDate;
    private String UserName;
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCohortStartDate() {
        return cohortStartDate;
    }

    public void setCohortStartDate(LocalDate cohortStartDate) {
        this.cohortStartDate = cohortStartDate;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
