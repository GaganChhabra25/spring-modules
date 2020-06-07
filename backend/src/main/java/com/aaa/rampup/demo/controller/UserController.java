package com.aaa.rampup.demo.controller;

import com.aaa.rampup.demo.exception.Preconditions;
import com.aaa.rampup.demo.model.User;
import com.aaa.rampup.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/users")
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public void create(@RequestBody User user) {
    userService.create(user);
  }

  @GetMapping("/{Id}")
  public User getById(@PathVariable Integer Id) {
    return userService.getById(Id);
  }

  @DeleteMapping("/{Id}")
  public void deleteById(@PathVariable Integer Id) {
    userService.delete(Id);
  }

  @PutMapping
  public User udpate(@RequestBody User user) {
    return userService.update(user);
  }
}
