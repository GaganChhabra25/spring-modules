package com.aaa.rampup.demo.services;

import com.aaa.rampup.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> getUsers();
  void create(User user);
  void delete(Integer Id);
  User update(User user);
  User getById(Integer Id);
}
