package com.aaa.rampup.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
/*Designates a class whose mapping information isapplied to the entities that inherit from it.
 A mapped superclass has no separate table defined for it.*/

@MappedSuperclass
@Setter@Getter
public class AbstractIdEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer Id;
}
