package com.aaa.rampup.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
public class AadharCard extends AbstractTimestampWithIdEntity{
  private String name;
  private LocalDate dob;
  private String gender;
}
