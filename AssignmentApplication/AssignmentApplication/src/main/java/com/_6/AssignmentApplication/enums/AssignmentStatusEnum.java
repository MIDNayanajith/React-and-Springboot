package com._6.AssignmentApplication.enums;

public enum AssignmentStatusEnum {

    PENDING_SUBMISSION("PENDING_SUBMISSION",0),
    SUBMITTED("SUBMITTED",1),
    IN_REVIEW("IN_REVIEW",2),
    NEEDS_UPDATE("NEEDS_UPDATE",3),
    COMPLETED("COMPLETED",4);

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
