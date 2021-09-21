package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.converter.DepartmentConverter;
import com.kashuba.simplewebapp.dao.DepartmentRepository;
import com.kashuba.simplewebapp.dto.DepartmentDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDepartmentService implements DepartmentService{

  @Autowired
  private DepartmentConverter departmentConverter;

  @Autowired
  private DepartmentRepository departmentRepository;

  @Override
  public Long create(DepartmentDto departmentDto) {
    return departmentRepository.save(departmentConverter.toModel(departmentDto)).getId();
  }

  @Override
  public void delete(Long id) {
    departmentRepository.deleteById(id);
  }

  @Override
  public List<DepartmentDto> getAll() {
    return departmentRepository.findAll()
        .stream().map(departmentConverter::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<DepartmentDto> get(Long id) {
    return Optional.of(departmentConverter.toDto(departmentRepository.findById(id).get()));
  }
}
