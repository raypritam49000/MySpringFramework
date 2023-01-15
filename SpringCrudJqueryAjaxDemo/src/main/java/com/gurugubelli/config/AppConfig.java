package com.gurugubelli.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScans(value = { 
		@ComponentScan("com.gurugubelli.dao"), 
		@ComponentScan("com.gurugubelli.service") 
})
public class AppConfig {

	@Bean
	public DataSource DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("1998");
		return dataSource;
	}
}
