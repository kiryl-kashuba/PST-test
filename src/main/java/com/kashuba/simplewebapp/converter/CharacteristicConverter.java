package com.kashuba.simplewebapp.converter;

import com.kashuba.simplewebapp.dto.CharacteristicDto;
import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.entity.Characteristic;
import com.kashuba.simplewebapp.entity.Department;
import com.kashuba.simplewebapp.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicConverter {

  public Characteristic toModel(CharacteristicDto characteristicDto) {
    return new Characteristic(characteristicDto.getId(),
        characteristicDto.getTemperament(),
        characteristicDto.getNumberCompletedProjects(),
        characteristicDto.getMaritalStatus(),
        characteristicDto.getHobbies(),
        new Employee(characteristicDto.getEmployeeId()));
  }

  public CharacteristicDto toDto(Characteristic characteristic) {
    return new CharacteristicDto(characteristic.getId(),
        characteristic.getTemperament(),
        characteristic.getNumberCompletedProjects(),
        characteristic.getMaritalStatus(),
        characteristic.getHobbies(),
        characteristic.getEmployee().getId());
  }
}
