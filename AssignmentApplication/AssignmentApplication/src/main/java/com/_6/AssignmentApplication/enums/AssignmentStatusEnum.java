package com._6.AssignmentApplication.enums;

public enum AssignmentStatusEnum {

    PENDING_SUBMISSION("PENDING_SUBMISSION",1),
    SUBMITTED("SUBMITTED",2),
    IN_REVIEW("IN_REVIEW",3),
    NEEDS_UPDATE("NEEDS_UPDATE",4),
    COMPLETED("COMPLETED",5);

    private String status;
    private Integer step;
    AssignmentStatusEnum(String status,Integer step){
        this.status = status   ;
        this.step = step;
    }

    public String getStatus(){
        return status;
    }
    public Integer getStep(){
        return step;
    }
}
