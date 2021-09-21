package com.kashuba.simplewebapp.converter;

import com.kashuba.simplewebapp.dto.ProjectDto;
import com.kashuba.simplewebapp.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectConverter {

  public Project toModel(ProjectDto projectDto) {
    return new Project(projectDto.getId(),
        projectDto.getName(),
        projectDto.getTotalProfit());
  }

  public ProjectDto toDto(Project project) {
    return new ProjectDto(project.getId(),
        project.getName(),
        project.getTotalProfit());
  }
}
