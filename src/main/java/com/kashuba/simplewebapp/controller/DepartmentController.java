package com.kashuba.simplewebapp.controller;

import com.kashuba.simplewebapp.dto.DepartmentDto;
import com.kashuba.simplewebapp.service.DepartmentService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @PostMapping
  public Long createClient(@RequestBody DepartmentDto departmentDto) {
    return departmentService.create(departmentDto);
  }

  @GetMapping("/{id}")
  public Optional<DepartmentDto> get(@PathVariable Long id) {
    return departmentService.get(id);
  }

  @GetMapping("/all")
  public List<DepartmentDto> getAll() {
    return departmentService.getAll();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    departmentService.delete(id);
  }

//  @PutMapping
//  public int update(@Valid @RequestBody EmployeeDto employeeDto) {
//    return defaultEmployeeService.update(employeeDto);
//  }

}
