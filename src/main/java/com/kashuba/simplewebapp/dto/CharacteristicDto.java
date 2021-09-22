package com.kashuba.simplewebapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CharacteristicDto {

  private long id;
  private String temperament;
  private Integer numberCompletedProjects;
  private String maritalStatus;
  private String hobbies;
  private Long employeeId;

  @JsonCreator
  public CharacteristicDto(
      @JsonProperty("id") long id,
      @JsonProperty("temperament") String temperament,
      @JsonProperty("numberCompletedProjects") Integer numberCompletedProjects,
      @JsonProperty("maritalStatus") String maritalStatus,
      @JsonProperty("hobbies") String hobbies,
      @JsonProperty("employeeId") Long employeeId) {
    this.id = id;
    this.temperament = temperament;
    this.numberCompletedProjects = numberCompletedProjects;
    this.maritalStatus = maritalStatus;
    this.hobbies = hobbies;
    this.employeeId = employeeId;
  }
}
