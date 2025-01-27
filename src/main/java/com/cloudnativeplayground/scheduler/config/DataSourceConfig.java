package com.cloudnativeplayground.scheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/job_scheduler_db?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root"); // Replace with your MySQL username
        dataSource.setPassword("password"); // Replace with your MySQL password

        return dataSource;
    }
}
