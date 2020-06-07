package com.aaa.rampup.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Address extends AbstractTimestampWithIdEntity {
  private String state;
  private String city;
  private String houseNumber;
  private Integer pin;
}
