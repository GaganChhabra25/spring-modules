package com.aaa.rampup.demo.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter@Builder
@Entity
@Table(name = "users")
public class User extends AbstractTimestampWithIdEntity{
  private String firstName;
  private String lastName;
}
