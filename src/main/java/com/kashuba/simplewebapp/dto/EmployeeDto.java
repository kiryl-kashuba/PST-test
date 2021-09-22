package com.kashuba.simplewebapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kashuba.simplewebapp.entity.enumeration.Gender;
import lombok.Data;

@Data
public class EmployeeDto {

  private long employeeDtoId;
  private String firstName;
  private String lastName;
  private String jobTitle;
  private Gender gender;
  private Long departmentId;
  private Long characteristicId;

  @JsonCreator
  public EmployeeDto(
      @JsonProperty("employeeId") Long employeeDtoId,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("jobTitle") String jobTitle,
      @JsonProperty("gender") Gender gender,
      @JsonProperty("departmentId") Long departmentId) {
    this.employeeDtoId = employeeDtoId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
    this.gender = gender;
    this.departmentId = departmentId;
  }

  public EmployeeDto(String firstName, String lastName, String jobTitle,
      Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
    this.gender = gender;
  }

  public EmployeeDto(long employeeDtoId) {
    this.employeeDtoId = employeeDtoId;
  }

  public EmployeeDto(String firstName, String lastName, String jobTitle,
      Gender gender, Long departmentId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
    this.gender = gender;
    this.departmentId = departmentId;
  }
}