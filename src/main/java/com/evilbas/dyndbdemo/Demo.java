package com.evilbas.dyndbdemo;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Demo {
	
	static Logger logger = Logger.getLogger(Demo.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);

	}
	
	@Autowired
	private Environment env;

	@Bean
	@Primary
	DataSource dataSource() {
		logger.info("Initiating data source");
		String username = env.getProperty("db.mysql.username");
		String password = env.getProperty("db.mysql.password");
		String url = env.getProperty("db.mysql.url");
		String driverClassName = env.getProperty("db.mysql.driverclass");
		System.out.println("Driver class: " + driverClassName);
		return DataSourceBuilder.create().username(username).password(password).url(url)
				.driverClassName(driverClassName).build();
	}
}
