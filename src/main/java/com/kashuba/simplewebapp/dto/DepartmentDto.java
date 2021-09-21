package com.kashuba.simplewebapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDto {

  private long id;
  private String name;

  @JsonCreator
  public DepartmentDto(
      @JsonProperty("departmentId")long id,
      @JsonProperty("name") String name) {
    this.id = id;
    this.name = name;
  }
}
