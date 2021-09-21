package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.converter.ProjectConverter;
import com.kashuba.simplewebapp.dao.ProjectRepository;
import com.kashuba.simplewebapp.dto.ProjectDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultProjectService implements ProjectService {

  @Autowired
  private ProjectConverter projectConverter;

  @Autowired
  private ProjectRepository projectRepository;

  @Override
  public Long create(ProjectDto projectDto) {
    return projectRepository.save(projectConverter.toModel(projectDto)).getId();
  }

  @Override
  public void delete(Long id) {
    projectRepository.deleteById(id);
  }

  @Override
  public List<ProjectDto> getAll() {
    return projectRepository.findAll()
        .stream().map(projectConverter::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<ProjectDto> get(Long id) {
    return Optional.of(projectConverter.toDto(projectRepository.findById(id).get()));
  }
}
