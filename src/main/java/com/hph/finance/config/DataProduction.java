package com.hph.finance.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("production")
@Configuration
public class DataProduction {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://db1.sepa-ok.de/finance");
        dataSource.setUsername("finance");
        dataSource.setPassword("4ZGlKGxgGUa0PJLemGF7uwdxmhj2keyL");
        return dataSource;
    }
}
