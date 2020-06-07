package com.aaa.rampup.demo.repository;

import com.aaa.rampup.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  Employee findByEmail(String email);
}
