package com.project.hrbank.dto.response;

import com.project.hrbank.dto.EmployeeDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CursorPageResponseEmployeeDto {

  private List<EmployeeDto> content;
  private String nextCursor;
  private Long nextIdAfter;
  private Integer size;
  private Long totalElements;
  private Boolean hasNext;
}