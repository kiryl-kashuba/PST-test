package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.dto.EmployeeDto;

public interface EmployeeService extends Crud<EmployeeDto> {

  Long addEmployeeToProject(Long idEmployee, Long idProject);
}