package com.project.hrbank.dto.response;

public record DepartmentDto(
        Integer id,
        String name,
        String description,
        String establishedDate,
        Integer employeeCount
){ }
