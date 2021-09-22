package com.kashuba.simplewebapp.dataLoader;

import com.kashuba.simplewebapp.dao.CharacteristicRepository;
import com.kashuba.simplewebapp.dao.DepartmentRepository;
import com.kashuba.simplewebapp.dao.EmployeeRepository;
import com.kashuba.simplewebapp.dao.ProjectRepository;
import com.kashuba.simplewebapp.entity.Characteristic;
import com.kashuba.simplewebapp.entity.Department;
import com.kashuba.simplewebapp.entity.Employee;
import com.kashuba.simplewebapp.entity.Project;
import com.kashuba.simplewebapp.entity.enumeration.Gender;
import com.kashuba.simplewebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private CharacteristicRepository characteristicRepository;

  @Autowired
  private EmployeeService employeeService;

  public void run(ApplicationArguments args) {
    departmentRepository.save(new Department("Dog department"));
    departmentRepository.save(new Department("Kak dela department"));
    departmentRepository.save(new Department("Back-end department"));
    departmentRepository.save(new Department("Front-end department"));
    departmentRepository.save(new Department("Front-end department"));
    departmentRepository.save(new Department("Cat department"));
    departmentRepository.save(new Department("Dog department"));
    departmentRepository.save(new Department("Kak dela department"));
    employeeRepository.save(new Employee("Eddy", "Merson", "driver",
        Gender.MALE, departmentRepository.getById(1L)));
    employeeRepository.save(new Employee("Eddy", "Merson", "driver",
        Gender.MALE, departmentRepository.getById(1L)));
    employeeRepository.save(new Employee("Eddy", "Merson", "driver",
        Gender.MALE, departmentRepository.getById(1L)));
    employeeRepository.save(new Employee("Eddy", "Merson", "driver",
        Gender.MALE, departmentRepository.getById(1L)));
    employeeRepository.save(new Employee("Eddy", "Merson", "driver",
        Gender.MALE, departmentRepository.getById(1L)));
    employeeRepository.save(new Employee("Eddy", "Merson", "driver",
        Gender.MALE, departmentRepository.getById(1L)));
    employeeRepository.save(new Employee("Eddy", "Merson", "driver",
        Gender.MALE, departmentRepository.getById(1L)));
    employeeRepository.save(new Employee("Eddy", "Merson", "driver",
        Gender.MALE, departmentRepository.getById(1L)));
    characteristicRepository.save(new Characteristic("Good, Active, Positive", 1, "married", "Pool, Dogs, "
        + "Sport, WOW", employeeRepository.findById(1L).get()));
    characteristicRepository.save(new Characteristic("Good, Active, Positive", 1, "married", "Pool, Dogs, "
        + "Sport, WOW", employeeRepository.findById(2L).get()));
    characteristicRepository.save(new Characteristic("Good, Active, Positive", 1, "married", "Pool, Dogs, "
        + "Sport, WOW", employeeRepository.findById(3L).get()));
    characteristicRepository.save(new Characteristic("Good, Active, Positive", 1, "married", "Pool, Dogs, "
        + "Sport, WOW", employeeRepository.findById(4L).get()));
    characteristicRepository.save(new Characteristic("Good, Active, Positive", 1, "married", "Pool, Dogs, "
        + "Sport, WOW", employeeRepository.findById(5L).get()));
    characteristicRepository.save(new Characteristic("Good, Active, Positive", 1, "married", "Pool, Dogs, "
        + "Sport, WOW", employeeRepository.findById(6L).get()));
    characteristicRepository.save(new Characteristic("Good, Active, Positive", 1, "married", "Pool, Dogs, "
        + "Sport, WOW", employeeRepository.findById(7L).get()));
    characteristicRepository.save(new Characteristic("Good, Active, Positive", 1, "married", "Pool, Dogs, "
        + "Sport, WOW", employeeRepository.findById(8L).get()));
    projectRepository.save(new Project("cartPorject", 10000000l));
    projectRepository.save(new Project("CoolPorject", 10000000l));
    projectRepository.save(new Project("GoodPorject", 10000000l));
    projectRepository.save(new Project("KakDelaject", 10000000l));
    projectRepository.save(new Project("CoolPorject", 10000000l));
    projectRepository.save(new Project("GoodPorject", 10000000l));
    projectRepository.save(new Project("KakDelaject", 10000000l));
    projectRepository.save(new Project("CoolPorject", 10000000l));
    projectRepository.save(new Project("KakDelaPorject", 10000000l));
  }
}
