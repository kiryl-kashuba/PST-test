package com.kashuba.simplewebapp.converter;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.entity.Department;
import com.kashuba.simplewebapp.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

  public Employee toModel(EmployeeDto employeeDto) {
    return new Employee(employeeDto.getEmployeeDtoId(),
        employeeDto.getFirstName(),
        employeeDto.getLastName(),
        employeeDto.getJobTitle(),
        employeeDto.getGender(),
        new Department(employeeDto.getDepartmentId()));
  }

  public EmployeeDto toDto(Employee employee) {
    return new EmployeeDto(employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getJobTitle(),
        employee.getGender(),
        employee.getDepartment().getId());
  }
}
