package com.kashuba.simplewebapp.controller;

import com.kashuba.simplewebapp.dto.CharacteristicDto;
import com.kashuba.simplewebapp.service.CharacteristicService;
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
@Api(tags = "Controller of characteristics")
@RequestMapping("/characteristics")
public class CharacteristicController {

  @Autowired
  private CharacteristicService characteristicService;

  @ApiOperation(value = "Create characteristic")
  @PostMapping
  public Long create(@RequestBody CharacteristicDto characteristicDto) {
    return characteristicService.create(characteristicDto);
  }

  @ApiOperation(value = "Find characteristic by ID")
  @GetMapping("/{id}")
  public Optional<CharacteristicDto> get(@PathVariable Long id) {
    return characteristicService.get(id);
  }

  @ApiOperation(value = "Find all characteristics")
  @GetMapping("/all")
  public List<CharacteristicDto> getAll() {
    return characteristicService.getAll();
  }

  @ApiOperation(value = "Delete characteristic")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    characteristicService.delete(id);
  }

//  @PutMapping
//  public int update(@Valid @RequestBody EmployeeDto employeeDto) {
//    return defaultEmployeeService.update(employeeDto);
//  }
}