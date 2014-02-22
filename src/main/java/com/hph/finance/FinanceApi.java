package com.hph.finance;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
public class FinanceApi {
	
	@Autowired
	private DataSource dataSource;
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(FinanceApi.class, args);
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    	
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
