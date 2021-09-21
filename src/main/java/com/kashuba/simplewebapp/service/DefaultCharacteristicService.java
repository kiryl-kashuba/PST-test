package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.converter.CharacteristicConverter;
import com.kashuba.simplewebapp.converter.EmployeeConverter;
import com.kashuba.simplewebapp.dao.CharacteristicRepository;
import com.kashuba.simplewebapp.dao.DepartmentRepository;
import com.kashuba.simplewebapp.dao.EmployeeRepository;
import com.kashuba.simplewebapp.dto.CharacteristicDto;
import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.entity.Characteristic;
import com.kashuba.simplewebapp.entity.Employee;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCharacteristicService implements CharacteristicService {

  @Autowired
  private CharacteristicRepository characteristicRepository;

  @Autowired
  private CharacteristicConverter characteristicConverter;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Long create(CharacteristicDto characteristicDto) {
    Characteristic characteristic = characteristicConverter.toModel(characteristicDto);
    characteristic.setEmployee(employeeRepository.getById(characteristicDto.getEmployeeId()));
    return (characteristicRepository.saveAndFlush(characteristic)).getId();
  }

//  public int update(EmployeeDto employeeDto) {
//    return 0;
//  }

  @Override
  public void delete(Long id) {
    characteristicRepository.deleteById(id);
  }

  @Override
  public List<CharacteristicDto> getAll() {
    return characteristicRepository.findAll()
        .stream().map(characteristicConverter::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<CharacteristicDto> get(Long id) {
    return Optional.of(characteristicConverter.toDto(characteristicRepository.findById(id).get()));
  }
}