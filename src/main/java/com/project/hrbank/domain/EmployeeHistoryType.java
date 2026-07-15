package com.project.hrbank.domain;

public enum EmployeeHistoryType {

    EMPLOYEE_ADD("CREATED"),
    EMPLOYEE_UPDATED("UPDATED"),
    EMPLOYEE_DELETED("DELETED");


    private final String status;

    EmployeeHistoryType(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }

}