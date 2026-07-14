package com.project.hrbank.service.basic;


import com.project.hrbank.domain.Employee;
import com.project.hrbank.domain.EmployeeStatus;
import com.project.hrbank.dto.EmployeeDto;
import com.project.hrbank.repository.EmployeeRepository;
import com.project.hrbank.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class BasicEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public long countEmployees(EmployeeStatus status, LocalDate fromDate, LocalDate toDate) {
        Instant from = fromDate != null ? fromDate.atStartOfDay(ZoneOffset.UTC).toInstant() : null;
        Instant to = toDate != null
                ? toDate.plusDays(1).atStartOfDay(ZoneOffset.UTC).toInstant()
                : (from != null ? Instant.now() : null);

        return employeeRepository.countByStatusAndHireDateRange(status, from, to);
    }

    @Override
    public List<EmployeeDto> getEmployees(
        String sort,
        String direction
    ) {

        Sort sortOption;

        if ("desc".equalsIgnoreCase(direction)) {
            sortOption = Sort.by(sort).descending();
        } else {
            sortOption = Sort.by(sort).ascending();
        }

        List<Employee> employees =
            employeeRepository.findAll(sortOption);

        return employees.stream()
            .map(employee -> new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getEmployeeNumber(),
                employee.getDepartment().getId(),
                employee.getDepartment().getDepartmentName(),
                employee.getPosition(),
                employee.getHireDate(),
                employee.getStatus(),
                employee.getProfileImaged() != null
                    ? employee.getProfileImaged().getId()
                    : null
            ))
            .toList();
    }
}
