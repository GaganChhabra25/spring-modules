package com.aaa.rampup.demo.model;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Technology extends AbstractTimestampWithIdEntity {
  private String name;
}
