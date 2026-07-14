package com.project.hrbank.dto;

import com.project.hrbank.domain.EmployeeStatus;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeDto {

  private Long id;
  private String name;
  private String email;
  private String employeeNumber;
  private Long departmentId;
  private String departmentName;
  private String position;
  private Instant hireDate;
  private EmployeeStatus status;
  private Long profileImageId;
}
