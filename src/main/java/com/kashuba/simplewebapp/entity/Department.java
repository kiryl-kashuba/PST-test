package com.kashuba.simplewebapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "departments")
@NoArgsConstructor
public class Department {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "id", nullable = true)
  private long id;
  private String name;
  @OneToMany(mappedBy = "department", orphanRemoval = true, fetch = FetchType.EAGER)
  @JsonIgnore
  private List<Employee> employees;

  public Department(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Department(long id) {
    this.id = id;
  }
}
