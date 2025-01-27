package com.cloudnativeplayground.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        // Launch the Spring Boot application
        SpringApplication.run(MainApplication.class, args);
        System.out.println("Scheduler Application Started");
    }
}
