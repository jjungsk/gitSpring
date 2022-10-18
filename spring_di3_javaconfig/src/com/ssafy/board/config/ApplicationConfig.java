package com.ssafy.board.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ComponentScan(basePackages = {"com.ssafy"})
public class ApplicationConfig {
	
	@Bean
	public DataSource getDataSource() {
		SimpleDriverDataSource ds = new SimpleDriverDataSource();
		ds.setDriverClass(com.mysql.cj.jdbc.Driver.class); // .class
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"); // amp; 제외
		ds.setUsername("ssafy");
		ds.setPassword("ssafy");
		return ds;
	}

}
