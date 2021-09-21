package com.kashuba.simplewebapp.converter;

import com.kashuba.simplewebapp.dto.DepartmentDto;
import com.kashuba.simplewebapp.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {

  public Department toModel(DepartmentDto departmentDto){
    return new Department(departmentDto.getId(),
        departmentDto.getName());
  }

  public DepartmentDto toDto(Department department){
    return new DepartmentDto(department.getId(),
        department.getName());
  }
}
