package com.aaa.rampup.demo.exception;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
  @Getter
  @Setter
  private String message;
}
