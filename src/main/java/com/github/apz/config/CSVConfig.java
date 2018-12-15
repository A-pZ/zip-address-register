package com.github.apz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.mygreen.supercsv.builder.SpringBeanFactory;

@Configuration
public class CSVConfig {
	@Bean
    public SpringBeanFactory springBeanFactory() {
        SpringBeanFactory factory = new SpringBeanFactory();
        return factory;
    }
}
