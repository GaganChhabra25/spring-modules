package com.aaa.rampup.demo.services;

import com.aaa.rampup.demo.model.Employee;

public interface EmployeeService {
  void create(Employee employee);
  Employee findByEmail(String email);
}
