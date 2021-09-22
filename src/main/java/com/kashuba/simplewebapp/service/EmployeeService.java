package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService extends Crud<EmployeeDto> {

  Long addEmployeeToProject(Long idEmployee, Long idProject);

  Page employeePageable(Pageable pageable);
}