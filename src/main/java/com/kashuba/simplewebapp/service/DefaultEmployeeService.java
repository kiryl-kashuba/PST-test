package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.converter.EmployeeConverter;
import com.kashuba.simplewebapp.dao.DepartmentRepository;
import com.kashuba.simplewebapp.dao.EmployeeRepository;
import com.kashuba.simplewebapp.dao.ProjectRepository;
import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.entity.Employee;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeService implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private EmployeeConverter employeeConverter;

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private ProjectRepository projectRepository;

  @Override
  public Long create(EmployeeDto employeeDto) {
    Employee employee = employeeConverter.toModel(employeeDto);
    employee.setDepartment(departmentRepository.getById(employeeDto.getDepartmentId()));
    return (employeeRepository.saveAndFlush(employee)).getId();
  }

  @Override
  public Long addEmployeeToProject(Long idEmployee, Long idProject) {
    Employee employee = employeeRepository.getById(idEmployee);
    employee.getEmployeeProject().add(projectRepository.findById(idProject).get());
    return (employeeRepository.saveAndFlush(employee)).getId();
  }

//  public int update(EmployeeDto employeeDto) {
//    return 0;
//  }

  @Override
  public void delete(Long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public List<EmployeeDto> getAll() {
    return employeeRepository.findAll()
        .stream().map(employeeConverter::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<EmployeeDto> get(Long id) {
    return Optional.of(employeeConverter.toDto(employeeRepository.findById(id).get()));
  }
}