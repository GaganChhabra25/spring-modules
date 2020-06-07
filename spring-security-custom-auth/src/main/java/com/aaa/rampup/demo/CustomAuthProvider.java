package com.aaa.rampup.demo;

import com.aaa.rampup.demo.exception.Preconditions;
import com.aaa.rampup.demo.model.Employee;
import com.aaa.rampup.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

  @Autowired
  private EmployeeService employeeService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    System.out.println("Verifying user");
    String email = authentication.getName();
    String password = authentication.getCredentials().toString();

    Employee existingEmployee = employeeService.findByEmail(email);
    Preconditions.checkServiceException(existingEmployee==null, "Employee not found");
    if(existingEmployee.getEmail().equalsIgnoreCase(email) &&
    existingEmployee.getPassword().trim().equalsIgnoreCase(password)) {
      List<GrantedAuthority> authorities = new ArrayList<>();
      System.out.println("User Verified");
      return new UsernamePasswordAuthenticationToken(existingEmployee, password, authorities);
    }
    System.out.println("User not Verified");
    return null;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
