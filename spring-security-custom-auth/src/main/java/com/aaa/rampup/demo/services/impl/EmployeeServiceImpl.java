package com.aaa.rampup.demo.services.impl;

import com.aaa.rampup.demo.model.Employee;
import com.aaa.rampup.demo.repository.EmployeeRepository;
import com.aaa.rampup.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public void create(Employee employee) {
      employeeRepository.save(employee);
  }

  @Override
  public Employee findByEmail(String email) {
    return employeeRepository.findByEmail(email);
  }
}
