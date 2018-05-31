package com.evilbas.dyndbdemo;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evilbas.dyndbcache.DynCache;

@Configuration
public class Config {
	
	@Bean
	DataSource dataSource() {
		DataSourceBuilder builder = new DataSourceBuilder();
		builder.
		return new DataSourceBuilder();
	}
	
	@Bean
	DynCache dynCache() {
		return new DynCache();
	}
}
