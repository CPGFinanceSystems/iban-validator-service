package com.hph.finance;

import com.hph.finance.resource.ResourceCollapsed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;


@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
public class FinanceApi {

    @Autowired
    private Environment env;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FinanceApi.class, args);
    }

    @PostConstruct
    public void initRestResources() {
        ResourceCollapsed.setBaseUrl(env.getProperty("app.baseUrl"));
    }
}
