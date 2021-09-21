package com.kashuba.simplewebapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProjectDto {

  private long id;
  private String name;
  private Long totalProfit;

  @JsonCreator
  public ProjectDto(
      @JsonProperty("id") Long id,
      @JsonProperty("name") String name,
      @JsonProperty("totalProfit") Long totalProfit) {
    this.id = id;
    this.name = name;
    this.totalProfit = totalProfit;
  }
}
