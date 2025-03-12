package com.example.banking.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.banking")
@EnableJpaRepositories(basePackages = "com.example.banking.repository")
@EntityScan(basePackages = "com.example.banking.model")
@Slf4j
public class BankingApplication {
    public static void main(String[] args) {
        log.info("Starting Banking Application...");
        SpringApplication.run(BankingApplication.class, args);
    }
}
