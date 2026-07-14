package com.project.hrbank.service;

import com.project.hrbank.domain.EmployeeStatus;
import com.project.hrbank.dto.response.CursorPageResponseEmployeeDto;

import java.time.LocalDate;

public interface EmployeeService {

    long countEmployees(
        EmployeeStatus status,
        LocalDate fromDate,
        LocalDate toDate
    );

    CursorPageResponseEmployeeDto getEmployees(
        String nameOrEmail,
        String employeeNumber,
        String departmentName,
        String position,
        LocalDate hireDateFrom,
        LocalDate hireDateTo,
        EmployeeStatus status,
        Long idAfter,
        String cursor,
        Integer size,
        String sortField,
        String sortDirection
    );
}
