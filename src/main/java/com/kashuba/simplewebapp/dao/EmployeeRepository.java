package com.kashuba.simplewebapp.dao;

import com.kashuba.simplewebapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

