package com.kashuba.simplewebapp.controller;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Controller of employees")
@RequestMapping("/employees")
public class EmployeeController {


  @Autowired
  private EmployeeService defaultEmployeeService;

  @ApiOperation(value = "Create employee")
  @PostMapping
  public Long create(@RequestBody EmployeeDto employeeDto) {
    return defaultEmployeeService.create(employeeDto);
  }

  @ApiOperation(value = "Find employee by ID")
  @GetMapping("/{id}")
  public Optional<EmployeeDto> get(@PathVariable Long id) {
    return defaultEmployeeService.get(id);
  }

  @ApiOperation(value = "Find all employees")
  @GetMapping("/all")
  public List<EmployeeDto> getAll() {
    return defaultEmployeeService.getAll();
  }

  @ApiOperation(value = "Delete employee")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    defaultEmployeeService.delete(id);
  }

//  @PutMapping
//  public int update(@Valid @RequestBody EmployeeDto employeeDto) {
//    return defaultEmployeeService.update(employeeDto);
//  }
}