package com.aaa.rampup.demo.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter@Getter@Builder
@Entity
public class Employee extends AbstractTimestampWithIdEntity{
  private String firstName;
  private String middleName;
  private String lastName;
  private String password;
  private String email;
  private String phoneNumber;

  @OneToOne
  @JoinColumn(name = "aadhar_card_id")
  @Cascade({CascadeType.ALL})
  private AadharCard aadharCard;

  @OneToMany()
  @JoinColumn(name = "user_id")
  @Cascade({CascadeType.ALL})
  private Set<Address> addresses = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "employee_technologies",
      joinColumns = @JoinColumn(
         name = "employee_id",
         referencedColumnName = "id"
      ),
      inverseJoinColumns = @JoinColumn(
         name = "technology_id",
          referencedColumnName = "id"
      )
  )
  private Set<Technology> technologies = new HashSet<>();
}
