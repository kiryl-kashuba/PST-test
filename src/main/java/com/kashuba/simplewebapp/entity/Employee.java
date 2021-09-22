package com.kashuba.simplewebapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kashuba.simplewebapp.entity.enumeration.Gender;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "employees")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

  @ManyToMany
  @JoinTable(
      name = "employee_project",
      joinColumns = @JoinColumn(name = "employee_id"),
      inverseJoinColumns = @JoinColumn(name = "project_id"))
  Set<Project> employeeProject;
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "id", nullable = true)
  private long id;
  @Column(name = "first_name", nullable = true)
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "job_title")
  private String jobTitle;
  @Enumerated(EnumType.STRING)
  @Column(name = "gender")
  private Gender gender;
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "department_id", nullable = true, insertable = true, updatable = true)
  private Department department;
  @JsonBackReference
  @OneToOne(optional = true, mappedBy = "employee", fetch = FetchType.EAGER)
  private Characteristic characteristic;

  public Employee(long id, String firstName, String lastName, String jobTitle,
      Gender gender, Department department) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
    this.gender = gender;
    this.department = department;
  }

  public Employee(long id) {
    this.id = id;
  }

  public Employee(String firstName, String lastName, String jobTitle,
      Gender gender, Department department) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
    this.gender = gender;
    this.department = department;
  }
}
