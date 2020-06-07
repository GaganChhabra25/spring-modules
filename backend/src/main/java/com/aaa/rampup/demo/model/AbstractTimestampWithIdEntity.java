package com.aaa.rampup.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter@Getter
@ToString
public class AbstractTimestampWithIdEntity extends AbstractIdEntity {

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;

  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModified;
}
