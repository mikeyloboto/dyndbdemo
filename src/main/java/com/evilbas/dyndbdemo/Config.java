package com.evilbas.dyndbdemo;

import java.util.List;
import java.util.Vector;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import com.evilbas.dyndbcache.DynCache;
import com.evilbas.dyndbcache.exception.DynDbException;
import com.evilbas.dyndbdemo.entity.DemoEntity;

@Configuration
@PropertySources({ @PropertySource("classpath:db.properties"), @PropertySource("classpath:credentials.properties") })
public class Config {

	static Logger logger = Logger.getLogger(Config.class.getName());	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private DynCache cacher;
	
	@Bean
	DynCache dynCache() {
		return new DynCache(dataSource);
	}
	
	@Bean
	Vector<?> demoEntity() {
		try {
			return cacher.registerList(DemoEntity.class);
		} catch (DynDbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
