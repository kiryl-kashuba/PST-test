package com.kashuba.simplewebapp.controller;

import com.kashuba.simplewebapp.dto.DepartmentDto;
import com.kashuba.simplewebapp.service.DepartmentService;
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
@Api(tags = "Controller of departments")
@RequestMapping("/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @ApiOperation(value = "Create department")
  @PostMapping
  public Long create(@RequestBody DepartmentDto departmentDto) {
    return departmentService.create(departmentDto);
  }

  @ApiOperation(value = "Find department by ID")
  @GetMapping("/{id}")
  public Optional<DepartmentDto> get(@PathVariable Long id) {
    return departmentService.get(id);
  }

  @ApiOperation(value = "Find all departments")
  @GetMapping("/all")
  public List<DepartmentDto> getAll() {
    return departmentService.getAll();
  }

  @ApiOperation(value = "Delete department")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    departmentService.delete(id);
  }

//  @PutMapping
//  public int update(@Valid @RequestBody EmployeeDto employeeDto) {
//    return defaultEmployeeService.update(employeeDto);
//  }
}
