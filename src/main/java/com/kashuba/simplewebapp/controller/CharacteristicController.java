package com.kashuba.simplewebapp.controller;

import com.kashuba.simplewebapp.dto.CharacteristicDto;
import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.service.CharacteristicService;
import com.kashuba.simplewebapp.service.EmployeeService;
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
@RequestMapping("/characteristics")
public class CharacteristicController {

  @Autowired
  private CharacteristicService characteristicService;

  @PostMapping
  public Long createClient(@RequestBody CharacteristicDto characteristicDto) {
    return characteristicService.create(characteristicDto);
  }

  @GetMapping("/{id}")
  public Optional<CharacteristicDto> get(@PathVariable Long id) {
    return characteristicService.get(id);
  }

  @GetMapping("/all")
  public List<CharacteristicDto> getAll() {
    return characteristicService.getAll();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    characteristicService.delete(id);
  }

//  @PutMapping
//  public int update(@Valid @RequestBody EmployeeDto employeeDto) {
//    return defaultEmployeeService.update(employeeDto);
//  }
}