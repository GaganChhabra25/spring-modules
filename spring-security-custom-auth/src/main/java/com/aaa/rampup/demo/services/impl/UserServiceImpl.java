package com.aaa.rampup.demo.services.impl;

import com.aaa.rampup.demo.exception.ServiceException;
import com.aaa.rampup.demo.model.User;
import com.aaa.rampup.demo.repository.UserRepository;
import com.aaa.rampup.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  @Transactional
  public void create(User user)  {
    try {
      userRepository.save(user);
    } catch (RuntimeException e){
      throw new ServiceException("Unable to save new User "+ user.getFirstName());
    }
  }

  @Override
  public void delete(Integer Id) {
    try {
      userRepository.deleteById(Id);
    } catch (RuntimeException e){
      throw new ServiceException("User to delete User with ID :" + Id);
    }
  }

  @Override
  public User update(User user) {
    Optional<User> optionalUser = userRepository.findById(user.getId());
    if(optionalUser.isPresent()) {
      User existingUser = optionalUser.get();
      existingUser.setFirstName(user.getFirstName());
      existingUser.setLastName(user.getLastName());
      return userRepository.saveAndFlush(existingUser);
    } else {
      throw new ServiceException("User not exist with ID :" + user.getId());
    }
  }

  @Override
  public User getById(Integer Id) {
    return userRepository
            .findById(Id)
            .orElseThrow(() -> new ServiceException("User not exist with ID :" + Id));
  }
}
