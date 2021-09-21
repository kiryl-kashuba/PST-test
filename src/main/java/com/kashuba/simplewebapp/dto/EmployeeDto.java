package com.kashuba.simplewebapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kashuba.simplewebapp.entity.enumeration.Gender;
import java.util.Date;
import lombok.Data;

@Data
public class EmployeeDto {

  private long employeeDtoId;
  private String firstName;
  private String lastName;
  private String jobTitle;
  private Gender gender;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date dateOfBirth;
  private Long departmentId;
  private Long characteristicId;

  @JsonCreator
  public EmployeeDto(
      @JsonProperty("employeeId") Long employeeDtoId,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("jobTitle") String jobTitle,
      @JsonProperty("gender") Gender gender,
      @JsonProperty("dateOfBirth") Date dateOfBirth,
      @JsonProperty("departmentId") Long departmentId) {
    this.employeeDtoId = employeeDtoId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.departmentId = departmentId;
  }
}