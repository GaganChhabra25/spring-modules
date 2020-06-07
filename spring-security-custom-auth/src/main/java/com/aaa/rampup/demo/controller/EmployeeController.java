package com.aaa.rampup.demo.controller;

import com.aaa.rampup.demo.model.Employee;
import com.aaa.rampup.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public void create(@RequestBody Employee employee) {
    employeeService.create(employee);
  }
}
