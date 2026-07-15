package com.project.hrbank.dto.response;

import java.time.Instant;

public record BackupCsvDTO(
        Long id,
        String employeeNumber,
        String name,
        String email,
        String department,
        String position,
        Instant hireDate,
        String status
) {
}
