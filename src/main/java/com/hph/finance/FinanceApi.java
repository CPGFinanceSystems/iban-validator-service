package com.hph.finance;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
public class FinanceApi {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(FinanceApi.class, args);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://db1.sepa-ok.de/finance");
        dataSource.setUsername("finance");
        dataSource.setPassword("4ZGlKGxgGUa0PJLemGF7uwdxmhj2keyL");
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    	
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);    	
    	jpaVendorAdapter.setDatabase(Database.MYSQL);
    	
    	LocalContainerEntityManagerFactoryBean emf = 
    			new LocalContainerEntityManagerFactoryBean();
    	emf.setPackagesToScan("com.hph.finance.data");
    	emf.setDataSource(dataSource);
    	emf.setJpaVendorAdapter(jpaVendorAdapter);
    	
    	return emf;
    }
}
