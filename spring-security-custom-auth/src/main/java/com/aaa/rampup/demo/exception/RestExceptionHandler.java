package com.aaa.rampup.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(ServiceException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ExceptionResponse> exception(ServiceException ex) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder()
            .message(ex.getMessage())
            .build();
    return ResponseEntity.status(500).body(exceptionResponse);
  }
}
