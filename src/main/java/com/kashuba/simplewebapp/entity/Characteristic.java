package com.kashuba.simplewebapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "characteristics")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Characteristic {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "id", nullable = true)
  private long id;
  private String temperament;
  private Integer numberCompletedProjects;
  private String maritalStatus;
  private String hobbies;
  @OneToOne(optional = true, cascade = CascadeType.PERSIST, orphanRemoval = true)
  @JoinColumn(name = "employee_id", nullable = true, unique = true)
  private Employee employee;

  public Characteristic(long id) {
    this.id = id;
  }

  public Characteristic(String temperament, Integer numberCompletedProjects, String maritalStatus,
      String hobbies, Employee employee) {
    this.temperament = temperament;
    this.numberCompletedProjects = numberCompletedProjects;
    this.maritalStatus = maritalStatus;
    this.hobbies = hobbies;
    this.employee = employee;
  }
}
