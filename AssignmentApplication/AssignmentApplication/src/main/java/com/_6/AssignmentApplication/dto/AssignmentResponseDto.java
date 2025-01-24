package com._6.AssignmentApplication.dto;

import com._6.AssignmentApplication.domain.Assignment;
import com._6.AssignmentApplication.enums.AssignmentEnum;
import com._6.AssignmentApplication.enums.AssignmentStatusEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AssignmentResponseDto {

    private Assignment assignment;
    private List<AssignmentEnumDto> assignmentEnum;
    private AssignmentStatusEnum[] statusEnums = AssignmentStatusEnum.values();

    public AssignmentResponseDto(Assignment assignment) {
        this.assignment = assignment;
        this.assignmentEnum = Arrays.stream(AssignmentEnum.values())
                .map(enumValue -> new AssignmentEnumDto(enumValue.getAssignmentNum(), enumValue.getAssignmentName()))
                .collect(Collectors.toList());
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public List<AssignmentEnumDto> getAssignmentEnum() {
        return assignmentEnum;
    }

    public AssignmentStatusEnum[] getStatusEnums() {
        return statusEnums;
    }

    public static class AssignmentEnumDto {
        private int assignmentNum;
        private String assignmentName;

        public AssignmentEnumDto(int assignmentNum, String assignmentName) {
            this.assignmentNum = assignmentNum;
            this.assignmentName = assignmentName;
        }

        public int getAssignmentNum() {
            return assignmentNum;
        }

        public String getAssignmentName() {
            return assignmentName;
        }
    }
}
