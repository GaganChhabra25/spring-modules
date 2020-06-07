package com.aaa.rampup.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JpaConfig {

  @Bean
  public AuditingEntityListener createAuditingListener() {
    return new AuditingEntityListener();
  }
}
