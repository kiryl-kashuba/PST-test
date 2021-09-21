package com.kashuba.simplewebapp.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "projects")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "id", nullable = true)
  private long id;
  @Column(name = "name", nullable = true)
  private String name;
  @Column(name = "profit")
  private Long totalProfit;
  @ManyToMany(mappedBy = "employeeProject")
  Set<Employee> employees;

  public Project(long id, String name, Long totalProfit) {
    this.id = id;
    this.name = name;
    this.totalProfit = totalProfit;
  }

  public Project(String name, Long totalProfit) {
    this.name = name;
    this.totalProfit = totalProfit;
  }
}
