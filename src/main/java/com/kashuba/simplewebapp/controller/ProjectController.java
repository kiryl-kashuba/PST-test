package com.kashuba.simplewebapp.controller;

import com.kashuba.simplewebapp.dto.ProjectDto;
import com.kashuba.simplewebapp.service.ProjectService;
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
@Api(tags = "Controller of projects")
@RequestMapping("/projects")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @ApiOperation(value = "Create service")
  @PostMapping
  public Long create(@RequestBody ProjectDto projectDto) {
    return projectService.create(projectDto);
  }

  @ApiOperation(value = "Find service by ID")
  @GetMapping("/{id}")
  public Optional<ProjectDto> get(@PathVariable Long id) {
    return projectService.get(id);
  }

  @ApiOperation(value = "Find all services")
  @GetMapping("/all")
  public List<ProjectDto> getAll() {
    return projectService.getAll();
  }

  @ApiOperation(value = "Delete service")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    projectService.delete(id);
  }

//  @PutMapping
//  public int update(@Valid @RequestBody EmployeeDto employeeDto) {
//    return defaultEmployeeService.update(employeeDto);
//  }
}
