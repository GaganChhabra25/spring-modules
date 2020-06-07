package com.aaa.rampup.demo.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Preconditions {

  public static void checkServiceException(boolean condition, String message) {
    if (condition) {
      throw new ServiceException(message);
    }
  }

}
