package com.kashuba.simplewebapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.service.DefaultEmployeeService;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrudTest {

  @Autowired
  private DefaultEmployeeService defaultEmployeeService;

  @Test
  public void get() {
    EmployeeDto employeeDto = defaultEmployeeService.get(3L).get();
    assertThat(employeeDto.getEmployeeDtoId()).isEqualTo(3);
  }

  @Test
  public void getAll() {
    List<EmployeeDto> employees = defaultEmployeeService.getAll();
    Assertions.assertThat(employees.size()).isGreaterThan(0);
  }
}