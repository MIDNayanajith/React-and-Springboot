package com._6.AssignmentApplication.enums;

public enum AssignmentEnum {

    ASSIGNMENT_1(1,"HTML Assignment"),
    ASSIGNMENT_2(2,"Guessing Game"),
    ASSIGNMENT_3(3,"User Login"),
    ASSIGNMENT_4(4,"Student course List "),
    ASSIGNMENT_5(5,"Custom Array List"),
    ASSIGNMENT_6(6,"Reports with Streams"),
    ASSIGNMENT_7(7,"Unit Testing"),
    ASSIGNMENT_8(8,"Multi Threading"),
    ASSIGNMENT_9(9,"Spring Mvc"),
    ASSIGNMENT_10(10,"Restful Service");

    private int assignmentNum;
    private String assignmentName;

    AssignmentEnum(int assignmentNum, String assignmentName) {
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
